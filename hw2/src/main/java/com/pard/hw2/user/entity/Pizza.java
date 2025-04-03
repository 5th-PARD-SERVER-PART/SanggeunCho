package com.pard.hw2.user.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Pizza {
    private int pizzaID;
    private String pizzaName;
    private int pizzaPrice;
    private String pizzaEdge;
}
