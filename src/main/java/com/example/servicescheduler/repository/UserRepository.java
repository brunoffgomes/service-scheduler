package com.example.servicescheduler.repository;

import com.example.servicescheduler.domain.User;
import com.example.servicescheduler.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    long countByRole(UserRole role);
}
