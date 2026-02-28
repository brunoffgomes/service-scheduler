package com.example.servicescheduler.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CLIENT")
public class ClientUser extends User {

    protected ClientUser() {
    }

    public ClientUser(String fullName, String email, String password) {
        super(fullName, email, password, UserRole.CLIENT);
    }
}
