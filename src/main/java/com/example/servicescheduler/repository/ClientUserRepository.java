package com.example.servicescheduler.repository;

import com.example.servicescheduler.domain.ClientUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientUserRepository extends JpaRepository<ClientUser, Long> {
}
