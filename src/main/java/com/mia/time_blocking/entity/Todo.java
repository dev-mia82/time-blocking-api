package com.mia.time_blocking.entity;

import com.mia.time_blocking.entity.common.Base;
import com.mia.time_blocking.entity.common.ScheduleBase;
import com.mia.time_blocking.type.Priority;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
public class Todo extends ScheduleBase {
    @Id
    @GeneratedValue
    @Column(name = "base_id")
    @Schema(description = "할일 PK")
    private Long id;

    @Schema(description = "소속 월")
    private LocalDate month;

    @OneToMany(mappedBy = "todo")
    private List<Schedule> schedule = new ArrayList<>();

}
