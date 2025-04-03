package com.pard.hw2.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PizzaDto {
    private int pizzaID;
    private String pizzaName;
    private int pizzaPrice;
    private String pizzaEdge;
}
