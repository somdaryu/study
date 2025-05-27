package com.example.demo.search.entity;

import com.example.demo.search.dto.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private LocalDateTime createdAt;
    private int age;

    public UserDTO toDTO() {
        String grade = getUserGrade(this.age);

        return UserDTO.builder()
                .id(this.id).name(this.name).email(this.email)
                .createdAt(String.valueOf(this.createdAt))
                .age(this.age).grade(grade)
                .build();
    }

    private String getUserGrade(int age) {
        if (age < 0) return "UNKNOWN";
        else if (age <= 12) return "CHILD";
        else if (age <= 19) return "TEEN";
        else if (age <= 64) return "ADULT";
        else return "SENIOR";
    }
}
