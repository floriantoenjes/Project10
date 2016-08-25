package com.floriantoenjes.home.automation.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.floriantoenjes.home.automation.core.BaseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    private String firstname;
    private String lastname;
    private String username;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String[] roles;

    public User() {
        super();
    }

    public User(String firstname, String lastname, String username, String password, String[] roles) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        setPassword(password);
        this.roles = roles;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
