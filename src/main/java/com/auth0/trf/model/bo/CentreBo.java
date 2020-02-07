package com.auth0.trf.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CENTRE")
public class CentreBo {

    @Id
    @Column(name = "CENTRE_NUMBER", nullable = false, unique = true, insertable = false)
    private String centreNumber;

    @Column(name = "CENTRE_NAME", nullable = false, unique = true, insertable = false)
    private String centreName;

    public String getCentreNumber() {
        return centreNumber;
    }

    public void setCentreNumber(String centreNumber) {
        this.centreNumber = centreNumber;
    }

    public String getCentreName() {
        return centreName;
    }

    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }

}
