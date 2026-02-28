package com.example.servicescheduler.web.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ScheduleServiceRequest(
        @NotNull Long clientUserId,
        @NotNull Long serviceProviderId,
        @NotNull @Future LocalDateTime scheduledAt
) {
}
