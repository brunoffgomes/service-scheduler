package com.example.servicescheduler.domain;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("PROVIDER")
public class ServiceProviderUser extends User {

    @Column(nullable = false)
    private String serviceType;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal serviceValue;

    @Column(nullable = false, precision = 2, scale = 1)
    private BigDecimal rating;

    protected ServiceProviderUser() {
    }

    public ServiceProviderUser(String fullName,
                               String email,
                               String password,
                               String serviceType,
                               BigDecimal serviceValue,
                               BigDecimal rating) {
        super(fullName, email, password, UserRole.PROVIDER);
        this.serviceType = serviceType;
        this.serviceValue = serviceValue;
        this.rating = rating;
    }

    public String getServiceType() {
        return serviceType;
    }

    public BigDecimal getServiceValue() {
        return serviceValue;
    }

    public BigDecimal getRating() {
        return rating;
    }
}
