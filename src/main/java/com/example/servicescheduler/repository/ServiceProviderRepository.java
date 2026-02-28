package com.example.servicescheduler.repository;

import com.example.servicescheduler.domain.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {
}
