package com.auth0.trf.util;

import com.auth0.trf.mapper.UserMapper;
import com.auth0.trf.model.bo.OrganisationApplicationBo;
import com.auth0.trf.model.bo.WebUserBo;
import com.auth0.trf.model.dto.UserDto;
import org.apache.commons.collections4.ListUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.LoadQueryInfluencers;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.impl.CriteriaImpl;
import org.hibernate.impl.SessionImpl;
import org.hibernate.loader.OuterJoinLoader;
import org.hibernate.loader.criteria.CriteriaLoader;
import org.hibernate.persister.entity.OuterJoinLoadable;
import org.hibernate.transform.AliasToBeanConstructorResultTransformer;
import org.hibernate.transform.Transformers;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AuthUtil {
    private UserMapper userMapper = new UserMapper();
    private static final int maxSize = 2000;

    public List<String> getAccountList() {
        List<WebUserBo> webUserBoList = this.listWebUsers();
        System.out.println(webUserBoList.size());
        List<UserDto> userDtoList = this.userMapper.mapEntityListToDtoList(webUserBoList);
        List<List<UserDto>> partitionList = this.partitionAccountList(userDtoList);
        List<String> accountList = new ArrayList<>();
        for (List<UserDto> userDtos : partitionList) {
            String jsonQuery = CommonUtil.toMinifyJson(userDtos);
            accountList.add(jsonQuery);
        }
        return accountList;
    }

    public List<List<UserDto>> partitionAccountList(List<UserDto> userDtoList) {
        List<List<UserDto>> partitionList = ListUtils.partition(userDtoList,  this.maxSize);
        return partitionList;
    }

    public List<WebUserBo> listWebUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT a FROM WebUserBo a " +
                    "INNER JOIN a.webUserOrganisationBo b " +
                    "INNER JOIN a.webUserRoleBo c " +
                    "INNER JOIN c.roleBo d " +
                    "INNER JOIN a.ieltsUserBo e " +
                    "WHERE d.name IN('IELTS Administrator', 'IELTS Support', 'IELTS User', 'RO Administrator')";
            System.out.println(hql);
            List<WebUserBo> webUserBoList = session.createQuery(hql).list();
            tx.commit();
            return webUserBoList;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public void getOrganisationApplicationBoList() throws ParseException, NoSuchFieldException, IllegalAccessException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        int organisationId = 180;
        try {
            tx = session.beginTransaction();

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
            sdf.setLenient(false);
            Date startDate = sdf.parse("01-JAN-16");
            Date endDate = sdf.parse("26-SEP-20");
            System.out.println(sdf.format(startDate));

//            String sql = "SELECT A.ORGANISATION_ID, A.CENTRE_NUMBER, A.TEST_DATE, A.LAST_MODIFIED, " +
//                    "B.CANDIDATE_NUMBER, B.FAMILY_NAME, B.GIVEN_NAME, B.DATE_OF_BIRTH, B.GENDER, " +
//                    "B.CERTID, B.ID_NUMBER, B.RESIT, B.RESIT_DATE, B.OVERALL_RESULT, " +
//                    "B.R_BAND_SCORE, B.L_BAND_SCORE, B.W_BAND_SCORE, B.S_BAND_SCORE " +
//                    "FROM ORGANISATIONAPPLICATION A " +
//                    "INNER JOIN CANDIDAT B " +
//                    "ON A.CANDIDATE_NUMBER = B.CANDIDATE_NUMBER " +
//                    "AND A.CENTRE_NUMBER = B.CENTRE_NUMBER " +
//                    "AND A.TEST_DATE = B.TEST_DATE " +
//                    "WHERE A.ORGANISATION_ID='180'" +
//                    "AND a.TEST_DATE BETWEEN :x AND :y";
//
//            SQLQuery sqlQuery = session.createSQLQuery(sql);
//            sqlQuery.setParameter("x", startDate);
//            sqlQuery.setParameter("y", endDate);
//
//            List<Object[]> rows = sqlQuery.list();
//            System.out.println(rows.size());
//            for(Object[] row : rows ){
//                System.out.println(row[2]);
//            }

            String hql = "SELECT a FROM OrganisationApplicationBo a " +
                    "INNER JOIN a.candidateBo b " +
                    "WHERE a.organisationId='180' " +
                    "AND a.testDate BETWEEN :x AND :y";

            Query query = session.createQuery(hql);
            query.setParameter("x", startDate);
            query.setParameter("y", endDate);


            List<OrganisationApplicationBo> organisationApplicationBoList = query.list();

            System.out.println(organisationApplicationBoList.get(0).getCandidateNumber());


        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
