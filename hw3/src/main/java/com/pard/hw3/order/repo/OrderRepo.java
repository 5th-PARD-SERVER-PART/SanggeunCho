package com.pard.hw3.order.repo;

import com.pard.hw3.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findByMenuAndPlaceAndPriceGreaterThanEqual(String menu, String place, int price);

    List<Order> findByPlaceAndRequestContaining(String place, String keyword);

    List<Order> findByMenuOrderByOrderTimeDesc(String menu);
}
