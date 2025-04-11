package com.pard.hw3.order.dto.res;

import lombok.*;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter

public class OrderResponseDto {
    private Long orderId;
    private String menu;
    private String request;
    private int price;
    private String place;
    private Timestamp orderTime;
}
