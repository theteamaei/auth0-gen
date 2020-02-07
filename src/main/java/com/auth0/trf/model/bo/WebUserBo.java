package com.auth0.trf.model.bo;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "WEBUSER")
public class WebUserBo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "webUserSeq")
    @SequenceGenerator(name = "webUserSeq", sequenceName = "WEBUSERSEQ")
    @Column(name = "WEB_USER_ID", nullable = false)
    private int webUserId;

    @Column(name = "EMAIL_ADDRESS", nullable = false)
    private String emailAddress;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "TELEPHONE_NO")
    private String telephone;

    @OneToOne
    @JoinColumn(name = "WEB_USER_ID", referencedColumnName = "WEB_USER_ID", insertable = false, updatable = false)
    private IeltsUserBo ieltsUserBo;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "WEB_USER_ID", referencedColumnName = "WEB_USER_ID", insertable = false, updatable = false)
    private List<WebUserOrganisationBo> webUserOrganisationBo;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumn(name = "WEB_USER_ID", referencedColumnName = "WEB_USER_ID", insertable = false, updatable = false)
    private List<WebUserRoleBo> webUserRoleBo;

    public int getWebUserId() {
        return webUserId;
    }

    public void setWebUserId(int webUserId) {
        this.webUserId = webUserId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public IeltsUserBo getIeltsUserBo() {
        return ieltsUserBo;
    }

    public void setIeltsUserBo(IeltsUserBo ieltsUserBo) {
        this.ieltsUserBo = ieltsUserBo;
    }

    public List<WebUserOrganisationBo> getWebUserOrganisationBo() {
        return webUserOrganisationBo;
    }

    public void setWebUserOrganisationBo(List<WebUserOrganisationBo> webUserOrganisationBo) {
        this.webUserOrganisationBo = webUserOrganisationBo;
    }

    public List<WebUserRoleBo> getWebUserRoleBo() {
        return webUserRoleBo;
    }

    public void setWebUserRoleBo(List<WebUserRoleBo> webUserRoleBo) {
        this.webUserRoleBo = webUserRoleBo;
    }
}
