package com.example.servicescheduler.repository;

import com.example.servicescheduler.domain.ServiceProviderUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceProviderUserRepository extends JpaRepository<ServiceProviderUser, Long> {
}
