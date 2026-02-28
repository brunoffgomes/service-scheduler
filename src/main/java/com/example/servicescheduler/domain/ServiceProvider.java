package com.example.servicescheduler.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_providers")
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String serviceType;

    @Column(nullable = false, unique = true)
    private String email;

    protected ServiceProvider() {
    }

    public ServiceProvider(String fullName, String serviceType, String email) {
        this.fullName = fullName;
        this.serviceType = serviceType;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getEmail() {
        return email;
    }
}
