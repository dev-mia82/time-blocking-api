package com.mia.time_blocking.dto;

import com.mia.time_blocking.type.Priority;
import com.mia.time_blocking.type.YesNo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record ScheduleUpdateRequest(
        @NotNull
        Long id,
        String title,
        String memo,
        LocalTime bgngTime,
        LocalTime endTime,
        String categoryId,
        Priority priority

) {
}
