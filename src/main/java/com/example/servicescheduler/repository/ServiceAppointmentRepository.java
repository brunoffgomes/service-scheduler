package com.example.servicescheduler.repository;

import com.example.servicescheduler.domain.ServiceAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceAppointmentRepository extends JpaRepository<ServiceAppointment, Long> {
}
