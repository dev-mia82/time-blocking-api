package com.mia.time_blocking.entity;

import com.mia.time_blocking.entity.common.Base;
import com.mia.time_blocking.entity.common.ScheduleBase;
import com.mia.time_blocking.type.Priority;
import com.mia.time_blocking.type.RoutineType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
public class Routine extends ScheduleBase {
    @Id @GeneratedValue
    @Column(name = "routine_id")
    @Schema(description = "루틴 PK")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Schema(description = "루틴 타입")
    private RoutineType type;

    @Column
    @Schema(description = "루틴 설정 시작 날짜")
    private LocalDate settingBgngDate;

    @Column
    @Schema(description =  "루틴 설정 종료 날짜")
    private LocalDate settingEndDate;

    @Schema(description = "일정")
    @OneToMany(mappedBy = "routine")
    private List<Schedule> schedule = new ArrayList<>();

}
