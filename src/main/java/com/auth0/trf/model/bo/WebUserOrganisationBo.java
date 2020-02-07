package com.auth0.trf.model.bo;

import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "WEBUSERORGANISATION")
public class WebUserOrganisationBo implements Serializable {
    @Id
    @Column(name = "ORGANISATION_ID", nullable = false)
    private int organisationId;

    @Column(name = "WEB_APPLICATION_ID", nullable = false)
    private int webApplicationId;

    @Column(name = "WEB_USER_ID", nullable = false)
    private int webUserId;

    public int getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(int organisationId) {
        this.organisationId = organisationId;
    }

    public int getWebApplicationId() {
        return webApplicationId;
    }

    public void setWebApplicationId(int webApplicationId) {
        this.webApplicationId = webApplicationId;
    }

    public int getWebUserId() {
        return webUserId;
    }

    public void setWebUserId(int webUserId) {
        this.webUserId = webUserId;
    }
}
