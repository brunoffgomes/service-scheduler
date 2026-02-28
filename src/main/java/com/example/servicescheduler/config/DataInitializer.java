package com.example.servicescheduler.config;

import com.example.servicescheduler.domain.Administrator;
import com.example.servicescheduler.domain.ClientUser;
import com.example.servicescheduler.domain.ServiceProvider;
import com.example.servicescheduler.repository.AdministratorRepository;
import com.example.servicescheduler.repository.ClientUserRepository;
import com.example.servicescheduler.repository.ServiceProviderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner seedData(ClientUserRepository clientUserRepository,
                               ServiceProviderRepository serviceProviderRepository,
                               AdministratorRepository administratorRepository) {
        return args -> {
            if (clientUserRepository.count() == 0) {
                clientUserRepository.save(new ClientUser("Default Client", "client@example.com"));
            }
            if (serviceProviderRepository.count() == 0) {
                serviceProviderRepository.save(new ServiceProvider("Default Provider", "Haircut", "provider@example.com"));
            }
            if (administratorRepository.count() == 0) {
                administratorRepository.save(new Administrator("Default Admin", "admin@example.com"));
            }
        };
    }
}
