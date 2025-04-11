package com.pard.hw3.order.dto.req;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter

public class OrderRequestDto {
    private String menu;
    private String request;
    private int price;
    private String place;
}
