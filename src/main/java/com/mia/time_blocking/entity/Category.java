package com.mia.time_blocking.entity;

import com.mia.time_blocking.type.Color;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
@Builder
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(name = "category_name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Color color;


}
