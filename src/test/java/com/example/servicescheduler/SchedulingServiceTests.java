package com.example.servicescheduler;

import com.example.servicescheduler.domain.ClientUser;
import com.example.servicescheduler.domain.ServiceAppointment;
import com.example.servicescheduler.domain.ServiceProviderUser;
import com.example.servicescheduler.repository.ClientUserRepository;
import com.example.servicescheduler.repository.ServiceProviderUserRepository;
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
    private ServiceProviderUserRepository serviceProviderUserRepository;

    @Test
    void shouldScheduleServiceForClientAndProvider() {
        ClientUser clientUser = clientUserRepository.findAll().getFirst();
        ServiceProviderUser providerUser = serviceProviderUserRepository.findAll().getFirst();

        ServiceAppointment appointment = schedulingService.schedule(
                new ScheduleServiceRequest(clientUser.getId(), providerUser.getId(), LocalDateTime.now().plusDays(1))
        );

        assertThat(appointment.getId()).isNotNull();
        assertThat(appointment.getClientUser().getId()).isEqualTo(clientUser.getId());
        assertThat(appointment.getServiceProvider().getId()).isEqualTo(providerUser.getId());
        assertThat(appointment.getServiceProvider().getServiceType()).isNotBlank();
        assertThat(appointment.getServiceProvider().getServiceValue()).isPositive();
        assertThat(appointment.getServiceProvider().getRating()).isPositive();
    }
}
