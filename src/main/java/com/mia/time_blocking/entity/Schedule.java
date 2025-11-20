package com.mia.time_blocking.entity;

import com.mia.time_blocking.entity.common.ScheduleBase;
import com.mia.time_blocking.type.Priority;
import com.mia.time_blocking.type.YesNo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends ScheduleBase {
    @Id @GeneratedValue
    @Column(name = "schedule_id")
    @Schema(description = "스케줄 PK")
    private Long id;

    @Schema(description = "완료여부")
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private YesNo completeYn = YesNo.N;

    @Schema(description = "루틴")
    @ManyToOne
    @JoinColumn(name = "routine_id")
    private Routine routine;

    @Schema(description = "할일")
    @ManyToOne
    @JoinColumn(name = "todo_id")
    private Todo todo;

    @OneToOne(mappedBy = "schedule")
    private Feedback feedback;

    @Builder
    public Schedule(Priority priority, String memo, Category category, String title, LocalTime bgngTime, LocalTime endTime, Routine routine, Todo todo) {
        super(priority, memo, category, title, bgngTime, endTime);
        this.routine = routine;
        this.todo = todo;
    }

    public void changeCompleteYn(YesNo completeYn) {
        this.completeYn = completeYn;
    }

    public void update(Priority priority, String memo, Category category, String title, LocalTime bgngTime, LocalTime endTime) {
        super.update(priority,memo,category,title,bgngTime,endTime);
    }
}
