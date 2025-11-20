package com.mia.time_blocking.entity;

import com.mia.time_blocking.entity.common.ScheduleBase;
import com.mia.time_blocking.type.Priority;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo extends ScheduleBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    @Schema(description = "할일 PK")
    private Long id;

    @Schema(description = "소속 월")
    private LocalDate todoMonth;

    @OneToMany(mappedBy = "todo")
    private List<Schedule> schedule = new ArrayList<>();

    @Builder
    public Todo(Priority priority, String memo, Category category, String title, LocalTime bgngTime, LocalTime endTime, LocalDate todoMonth) {
        super(priority, memo, category, title, bgngTime, endTime);
        this.todoMonth = todoMonth;
    }

    public void update(Priority priority, String memo, Category category, String title, LocalTime bgngTime, LocalTime endTime, LocalDate todoMonth) {
        super.update(priority, memo, category, title, bgngTime, endTime);
        this.todoMonth = todoMonth;
    }
}
