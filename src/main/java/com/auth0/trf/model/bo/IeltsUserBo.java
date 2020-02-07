package com.auth0.trf.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "IELTSUSER")
public class IeltsUserBo {

    @Id
    @Column(name = "WEB_USER_ID", nullable = false)
    private int webUserId;

    @Column(name = "FAX_NO")
    private String faxNo;

    @Column(name = "LAST_LOGIN")
    private Date lastLogin;

    @Column(name = "NOTES")
    private String notes;

    @Column(name = "PREVIOUS_LAST_LOGIN")
    private Date previousLastLogin;

    public int getWebUserId() {
        return webUserId;
    }

    public void setWebUserId(int webUserId) {
        this.webUserId = webUserId;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getPreviousLastLogin() {
        return previousLastLogin;
    }

    public void setPreviousLastLogin(Date previousLastLogin) {
        this.previousLastLogin = previousLastLogin;
    }

}
