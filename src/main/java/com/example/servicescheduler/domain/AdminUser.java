package com.example.servicescheduler.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class AdminUser extends User {

    protected AdminUser() {
    }

    public AdminUser(String fullName, String email, String password) {
        super(fullName, email, password, UserRole.ADMIN);
    }
}
