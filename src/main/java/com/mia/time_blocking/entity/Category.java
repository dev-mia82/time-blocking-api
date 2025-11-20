package com.mia.time_blocking.entity;

import com.mia.time_blocking.type.Color;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Color color;

    @Builder
    public Category(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public void update(String name,Color color) {
        this.name = name;
        this.color = color;
    }
}
