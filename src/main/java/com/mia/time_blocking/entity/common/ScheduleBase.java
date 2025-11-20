package com.mia.time_blocking.entity.common;

import com.mia.time_blocking.entity.Category;
import com.mia.time_blocking.type.Priority;
import com.mia.time_blocking.type.YesNo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@MappedSuperclass
public abstract class ScheduleBase {

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

    @Builder
    public ScheduleBase(Priority priority, String memo, Category category, String title, LocalTime bgngTime, LocalTime endTime) {
        this.priority = priority;
        this.memo = memo;
        this.category = category;
        this.title = title;
        this.bgngTime = bgngTime;
        this.endTime = endTime;
    }

    public void update(Priority priority, String memo, Category category, String title, LocalTime bgngTime, LocalTime endTime) {
        this.priority = priority;
        this.memo = memo;
        this.category = category;
        this.title = title;
        this.bgngTime = bgngTime;
        this.endTime = endTime;
    }
}
