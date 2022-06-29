package com.example.SpringSecurityJWTWithAngular.models;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ERole nameRole;

    public Role() {
    }

    public Role(ERole nameRole) {
        this.nameRole = nameRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getNameRole() {
        return nameRole;
    }

    public void setNameRole(ERole nameRole) {
        this.nameRole = nameRole;
    }
}
