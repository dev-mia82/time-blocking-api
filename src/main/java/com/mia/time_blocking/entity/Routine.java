package com.mia.time_blocking.entity;

import com.mia.time_blocking.entity.common.ScheduleBase;
import com.mia.time_blocking.type.Priority;
import com.mia.time_blocking.type.RoutineType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Routine extends ScheduleBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Builder
    public Routine(Priority priority, String memo, Category category, String title, LocalTime bgngTime, LocalTime endTime, RoutineType type, LocalDate settingBgngDate, LocalDate settingEndDate) {
        super(priority,memo,category,title,bgngTime,endTime );
        this.type = type;
        this.settingBgngDate = settingBgngDate;
        this.settingEndDate = settingEndDate;
    }

    public void update(Priority priority, String memo, Category category, String title, LocalTime bgngTime, LocalTime endTime, RoutineType type, LocalDate settingBgngDate, LocalDate settingEndDate) {
        super.update(priority, memo, category, title, bgngTime, endTime);
        this.type =type;
        this.settingBgngDate =settingBgngDate;
        this.settingEndDate = settingEndDate;
    }

}
