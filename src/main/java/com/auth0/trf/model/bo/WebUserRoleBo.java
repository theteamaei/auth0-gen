package com.auth0.trf.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "WEBUSERROLE")
public class WebUserRoleBo implements Serializable {

    @Id
    @Column(name = "WEB_USER_ID", nullable = false)
    private int webUserId;

    @Id
    @Column(name = "ROLE_ID",  nullable = false)
    private int roleId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID", insertable = false, updatable = false)
    private RoleBo roleBo;

    public int getWebUserId() {
        return webUserId;
    }

    public void setWebUserId(int webUserId) {
        this.webUserId = webUserId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public RoleBo getRoleBo() {
        return roleBo;
    }

    public void setRoleBo(RoleBo roleBo) {
        this.roleBo = roleBo;
    }
}
