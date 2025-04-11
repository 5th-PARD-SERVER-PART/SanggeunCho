package com.pard.hw3.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(length = 20)
    private String menu;

    @Column
    private String request;

    @Column
    private int price;

    @Column
    private String place;

    @CreationTimestamp
    private Timestamp orderTime;

    public void updateMenu(String menu){
        this.menu = menu;
    }

    public void updateRequest(String request){
        this.request = request;
    }

    public void updatePrice(int price){
        this.price = price;
    }

    public void updatePlace(String place){
        this.place = place;
    }
}
