package com.mia.time_blocking.entity;

import com.mia.time_blocking.entity.common.Base;
import com.mia.time_blocking.entity.common.ScheduleBase;
import com.mia.time_blocking.type.YesNo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Getter
@AllArgsConstructor
public class Schedule extends ScheduleBase {
    @Id @GeneratedValue
    @Column(name = "schedule_id")
    @Schema(description = "스케줄 PK")
    private Long id;

    @Schema(description = "완료여부")
    @Enumerated(EnumType.STRING)
    private YesNo completeYn;

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




}
