package com.example.SpringSecurityJWTWithAngular.repositories;

import com.example.SpringSecurityJWTWithAngular.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByNameRole(String nameRole);
}
