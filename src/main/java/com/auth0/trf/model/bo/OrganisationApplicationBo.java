package com.auth0.trf.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ORGANISATIONAPPLICATION")
public class OrganisationApplicationBo implements Serializable {

    @Id
    @Column(name = "ORGANISATION_ID", nullable = false)
    private int organisationId;

    @Id
    @OneToOne
    @JoinColumn(name = "CENTRE_NUMBER",referencedColumnName = "CENTRE_NUMBER", insertable = false, updatable = false)
    private CentreBo centreBo;

    @Id
    @Column(name = "CANDIDATE_NUMBER", nullable = false)
    private String candidateNumber;

    @Id
    @Column(name = "TEST_DATE", nullable = false)
    private Date testDate;

    @Column(name = "LAST_MODIFIED", nullable = false)
    private Date lastModified;

    @OneToOne
    @JoinColumns({
        @JoinColumn(name = "TEST_DATE", referencedColumnName = "TEST_DATE", insertable = false, updatable = false),
        @JoinColumn(name = "CENTRE_NUMBER",referencedColumnName = "CENTRE_NUMBER", insertable = false, updatable = false),
        @JoinColumn(name = "CANDIDATE_NUMBER", referencedColumnName = "CANDIDATE_NUMBER", insertable = false, updatable = false)
    })
    private CandidateBo candidateBo;

    public int getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(int organisationId) {
        this.organisationId = organisationId;
    }

    public CentreBo getCentreBo() {
        return centreBo;
    }

    public void setCentreBo(CentreBo centreBo) {
        this.centreBo = centreBo;
    }

    public String getCandidateNumber() {
        return candidateNumber;
    }

    public void setCandidateNumber(String candidateNumber) {
        this.candidateNumber = candidateNumber;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public CandidateBo getCandidateBo() {
        return candidateBo;
    }

    public void setCandidateBo(CandidateBo candidateBo) {
        this.candidateBo = candidateBo;
    }
}
