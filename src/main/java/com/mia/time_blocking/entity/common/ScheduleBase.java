package com.mia.time_blocking.entity.common;

import com.mia.time_blocking.entity.Category;
import com.mia.time_blocking.type.Priority;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ScheduleBase extends Base{

    @Schema(description = "중요도")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Schema(description = "메모")
    @Column
    private String memo;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Schema(description = "일정 제목")
    @Column
    private String title;

    @Column
    @Schema(description = "일정 시작 시간")
    private LocalTime bgngTime;

    @Column
    @Schema(description = "일정 종료 시간")
    private LocalTime endTime;
}
