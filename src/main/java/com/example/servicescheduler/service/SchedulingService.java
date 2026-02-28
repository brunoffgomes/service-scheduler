package com.example.servicescheduler.service;

import com.example.servicescheduler.domain.ClientUser;
import com.example.servicescheduler.domain.ServiceAppointment;
import com.example.servicescheduler.domain.ServiceProvider;
import com.example.servicescheduler.repository.ClientUserRepository;
import com.example.servicescheduler.repository.ServiceAppointmentRepository;
import com.example.servicescheduler.repository.ServiceProviderRepository;
import com.example.servicescheduler.web.dto.ScheduleServiceRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SchedulingService {

    private final ClientUserRepository clientUserRepository;
    private final ServiceProviderRepository serviceProviderRepository;
    private final ServiceAppointmentRepository serviceAppointmentRepository;

    public SchedulingService(ClientUserRepository clientUserRepository,
                             ServiceProviderRepository serviceProviderRepository,
                             ServiceAppointmentRepository serviceAppointmentRepository) {
        this.clientUserRepository = clientUserRepository;
        this.serviceProviderRepository = serviceProviderRepository;
        this.serviceAppointmentRepository = serviceAppointmentRepository;
    }

    @Transactional
    public ServiceAppointment schedule(ScheduleServiceRequest request) {
        ClientUser clientUser = clientUserRepository.findById(request.clientUserId())
                .orElseThrow(() -> new IllegalArgumentException("Client user not found: " + request.clientUserId()));

        ServiceProvider serviceProvider = serviceProviderRepository.findById(request.serviceProviderId())
                .orElseThrow(() -> new IllegalArgumentException("Service provider not found: " + request.serviceProviderId()));

        ServiceAppointment serviceAppointment = new ServiceAppointment(clientUser, serviceProvider, request.scheduledAt());
        return serviceAppointmentRepository.save(serviceAppointment);
    }
}
