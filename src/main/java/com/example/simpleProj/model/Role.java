package com.example.simpleProj.model;

import javax.persistence.*;

/**
 * Created by Kamarou_S on 29.06.2018.
 */
@Entity
@Table(name = "role")
public class Role {
    private long idRole;
    private String roleName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idRole", nullable = false)
    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    @Basic
    @Column(name = "roleName", nullable = false, length = 255)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (idRole != role.idRole) return false;
        if (roleName != null ? !roleName.equals(role.roleName) : role.roleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idRole ^ (idRole >>> 32));
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }
}
