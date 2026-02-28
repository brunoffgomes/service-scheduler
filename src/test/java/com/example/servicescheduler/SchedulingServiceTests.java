package com.example.servicescheduler;

import com.example.servicescheduler.domain.ServiceAppointment;
import com.example.servicescheduler.repository.ClientUserRepository;
import com.example.servicescheduler.repository.ServiceProviderRepository;
import com.example.servicescheduler.service.SchedulingService;
import com.example.servicescheduler.web.dto.ScheduleServiceRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SchedulingServiceTests {

    @Autowired
    private SchedulingService schedulingService;

    @Autowired
    private ClientUserRepository clientUserRepository;

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    @Test
    void shouldScheduleServiceForClientAndProvider() {
        Long clientUserId = clientUserRepository.findAll().getFirst().getId();
        Long providerId = serviceProviderRepository.findAll().getFirst().getId();

        ServiceAppointment appointment = schedulingService.schedule(
                new ScheduleServiceRequest(clientUserId, providerId, LocalDateTime.now().plusDays(1))
        );

        assertThat(appointment.getId()).isNotNull();
        assertThat(appointment.getClientUser().getId()).isEqualTo(clientUserId);
        assertThat(appointment.getServiceProvider().getId()).isEqualTo(providerId);
    }
}
