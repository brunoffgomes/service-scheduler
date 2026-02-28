package com.example.servicescheduler.web.dto;

import java.time.LocalDateTime;

public record ServiceAppointmentResponse(
        Long appointmentId,
        Long clientUserId,
        Long serviceProviderId,
        LocalDateTime scheduledAt
) {
}
