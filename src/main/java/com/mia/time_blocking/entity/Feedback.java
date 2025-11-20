package com.mia.time_blocking.entity;

import com.mia.time_blocking.type.Emotion;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Feedback {
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

    @Builder
    public Feedback(Emotion emotion, String content, Schedule schedule) {
        this.emotion = emotion;
        this.content = content;
        this.schedule = schedule;
    }

    public void update(Emotion emotion, String content) {
        this.emotion = emotion;
        this.content = content;
    }
}
