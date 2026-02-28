package com.example.servicescheduler.web;

import com.example.servicescheduler.domain.ServiceAppointment;
import com.example.servicescheduler.service.SchedulingService;
import com.example.servicescheduler.web.dto.ScheduleServiceRequest;
import com.example.servicescheduler.web.dto.ServiceAppointmentResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointments")
public class ServiceAppointmentController {

    private final SchedulingService schedulingService;

    public ServiceAppointmentController(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceAppointmentResponse schedule(@Valid @RequestBody ScheduleServiceRequest request) {
        ServiceAppointment appointment = schedulingService.schedule(request);
        return new ServiceAppointmentResponse(
                appointment.getId(),
                appointment.getClientUser().getId(),
                appointment.getServiceProvider().getId(),
                appointment.getScheduledAt()
        );
    }
}
