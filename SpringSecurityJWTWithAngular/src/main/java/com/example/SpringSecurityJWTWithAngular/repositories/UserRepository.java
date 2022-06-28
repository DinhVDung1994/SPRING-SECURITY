package com.example.SpringSecurityJWTWithAngular.repositories;

import com.example.SpringSecurityJWTWithAngular.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
