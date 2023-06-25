package com.example.workflow.dto.mapper;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDateTime dob;
    private Gender gender;
    private BigDecimal salary;
}
