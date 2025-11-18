package com.mia.time_blocking.entity.common;

import com.mia.time_blocking.type.YesNo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Base {
    @Column
    @Schema(description = "등록일")
    private LocalDate createdAt;
    @Column
    @Schema(description = "수정일")
    private LocalDate updatedAt;

    @Enumerated(EnumType.STRING)
    @Schema(description = "사용여부", defaultValue = "Y")
    private YesNo useYn;
}
