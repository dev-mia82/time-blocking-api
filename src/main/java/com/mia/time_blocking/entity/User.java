package com.mia.time_blocking.entity;

import com.mia.time_blocking.entity.common.Base;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Getter
@AllArgsConstructor
@Schema(description = "사용자 테이블")
public class User extends Base {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    @Schema(description = "사용자 PK")
    private Long id;
    @Column
    @Schema(description = "로그인 아이디")
    private String loginId;
    @Column
    @Schema(description = "이메일")
    private String email;
    @Column
    @Schema(description = "비밀번호")
    private String password;
    @Column
    @Schema(description = "사용자명")
    private String name;


}
