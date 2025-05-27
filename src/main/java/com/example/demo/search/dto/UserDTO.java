package com.example.demo.search.dto;

import com.example.demo.search.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private long id;
    @NotBlank(message = "이름은 필수입니다.")
    private String name;

    @Email(message = "이메일 형식이 올바르지 않습니다.")
    @NotBlank(message = "이메일은 필수입니다.")
    private String email;
    private String createdAt;
    private String grade;
    private int age;

    public User toEntity() {
        return User.builder()
                .id(this.id).name(this.name).email(this.email)
                .createdAt(LocalDateTime.parse(this.createdAt))
                .age(this.age).build();
    }
}
