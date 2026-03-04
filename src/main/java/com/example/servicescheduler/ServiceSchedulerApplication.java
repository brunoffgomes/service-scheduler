package com.example.servicescheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.servicescheduler.domain")
@EnableJpaRepositories(basePackages = "com.example.servicescheduler.repository")
public class ServiceSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSchedulerApplication.class, args);
    }
}
