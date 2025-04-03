package com.pard.seminar2.user.entiry;

import lombok.*;

@Getter // 외부에서 필드값 읽기 허용
@Setter // 외부에서 필드값 수정 허용
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 받을 수 있는 생성자 알아서 생성
@Builder

public class User {
    private long studentID;
    private String studentName;
}

// DB에 User 테이블과 칼럼들이 생김
// 그래서 쉽게 손대지 않는 것