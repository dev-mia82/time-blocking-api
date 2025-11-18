package com.mia.time_blocking.entity;

import com.mia.time_blocking.entity.common.Base;
import com.mia.time_blocking.type.Emotion;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@AllArgsConstructor
@Getter
public class Feedback extends Base {
    @Id @GeneratedValue
    @Column(name = "feedback_id")
    @Schema(description = "회고 PK")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Schema(description = "감정")
    private Emotion emotion;

    @Column
    @Schema(description = "회고 내용")
    private String content;

    @OneToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;


}
