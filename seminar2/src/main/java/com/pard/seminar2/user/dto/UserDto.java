package com.pard.seminar2.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDto {
    private Long studentID;
    private String studentName;
}
