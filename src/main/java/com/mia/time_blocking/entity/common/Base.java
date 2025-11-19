package com.mia.time_blocking.entity.common;

import com.mia.time_blocking.type.YesNo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class Base {
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
