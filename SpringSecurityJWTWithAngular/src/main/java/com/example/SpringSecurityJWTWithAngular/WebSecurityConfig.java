package com.example.SpringSecurityJWTWithAngular;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();//Ngăn chặn request từ một domain khác
        http.csrf().disable();
        // Phân quyền truy cập cho các request
        http.authorizeRequests().anyRequest().permitAll();// Cho phép tất cả mọi người đều có quyền truy cập
    }
}
