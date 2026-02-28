package com.example.servicescheduler.config;

import com.example.servicescheduler.domain.AdminUser;
import com.example.servicescheduler.domain.ClientUser;
import com.example.servicescheduler.domain.ServiceProviderUser;
import com.example.servicescheduler.domain.UserRole;
import com.example.servicescheduler.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner seedData(UserRepository userRepository) {
        return args -> {
            if (userRepository.countByRole(UserRole.CLIENT) == 0) {
                userRepository.save(new ClientUser("Default Client", "client@example.com", "{noop}client123"));
            }
            if (userRepository.countByRole(UserRole.PROVIDER) == 0) {
                userRepository.save(new ServiceProviderUser(
                        "Default Provider",
                        "provider@example.com",
                        "{noop}provider123",
                        "Haircut",
                        new BigDecimal("45.00"),
                        new BigDecimal("4.8")
                ));
            }
            if (userRepository.countByRole(UserRole.ADMIN) == 0) {
                userRepository.save(new AdminUser("Default Admin", "admin@example.com", "{noop}admin123"));
            }
        };
    }
}
