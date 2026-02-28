package com.example.servicescheduler.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "service_appointments")
public class ServiceAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_user_id", nullable = false)
    private ClientUser clientUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_provider_id", nullable = false)
    private ServiceProvider serviceProvider;

    @Column(nullable = false)
    private LocalDateTime scheduledAt;

    protected ServiceAppointment() {
    }

    public ServiceAppointment(ClientUser clientUser, ServiceProvider serviceProvider, LocalDateTime scheduledAt) {
        this.clientUser = clientUser;
        this.serviceProvider = serviceProvider;
        this.scheduledAt = scheduledAt;
    }

    public Long getId() {
        return id;
    }

    public ClientUser getClientUser() {
        return clientUser;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }
}
