package com.pard.hw3.order.service;

import com.pard.hw3.order.dto.req.OrderRequestDto;
import com.pard.hw3.order.dto.res.OrderResponseDto;
import com.pard.hw3.order.entity.Order;
import com.pard.hw3.order.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor

public class OrderService {
    private final OrderRepo orderRepo;

    public void save(OrderRequestDto orderDto){
        Order order = Order.builder()
                .menu(orderDto.getMenu())
                .request(orderDto.getRequest())
                .price(orderDto.getPrice())
                .place(orderDto.getPlace())
                .build();
        orderRepo.save(order);
    }

    public OrderResponseDto read(Long orderId){
        Order order = orderRepo.findById(orderId).get();

        return OrderResponseDto.builder()
                .menu(order.getMenu())
                .request(order.getRequest())
                .price(order.getPrice())
                .place(order.getPlace())
                .orderTime(order.getOrderTime())
                .build();
    }

    public Long getOrderMenu(String menu){
        Order order = orderRepo.findByMenu(menu);

        return order.getOrderId();
    }

    public List<OrderResponseDto> readAll(){
        List<Order> orders = orderRepo.findAll();
        List<OrderResponseDto> orderDtos = orders.stream().map(
                order -> OrderResponseDto.builder()
                        .menu(order.getMenu())
                        .request(order.getRequest())
                        .price(order.getPrice())
                        .place(order.getPlace())
                        .orderTime(order.getOrderTime())
                        .build()).toList();

        return orderDtos;
    }

    public List<OrderResponseDto> findMenuPlaceGreaterThanPrice(String menu, String place, int price){
        List<Order> orders = orderRepo.findByMenuAndPlaceAndPriceGreaterThanEqual(menu, place, price);
        List<OrderResponseDto> orderDtos = orders.stream().map(
                order -> OrderResponseDto.builder()
                        .menu(order.getMenu())
                        .request(order.getRequest())
                        .price(order.getPrice())
                        .place(order.getPlace())
                        .orderTime(order.getOrderTime())
                        .build()).toList();

        return orderDtos;
    }

    public List<OrderResponseDto> findPlaceKeywordOfRequest(String place, String keyword){
        List<Order> orders = orderRepo.findByPlaceAndRequestContaining(place, keyword);
        List<OrderResponseDto> orderDtos = orders.stream().map(
                order -> OrderResponseDto.builder()
                        .menu(order.getMenu())
                        .request(order.getRequest())
                        .price(order.getPrice())
                        .place(order.getPlace())
                        .orderTime(order.getOrderTime())
                        .build()).toList();

        return orderDtos;
    }

    public List<OrderResponseDto> findMenuTimeDesc(String menu){
        List<Order> orders = orderRepo.findByMenuOrderByOrderTimeDesc(menu);
        List<OrderResponseDto> orderDtos = orders.stream().map(
                order -> OrderResponseDto.builder()
                        .menu(order.getMenu())
                        .request(order.getRequest())
                        .price(order.getPrice())
                        .place(order.getPlace())
                        .orderTime(order.getOrderTime())
                        .build()).toList();

        return orderDtos;
    }

    @Transactional
    public void update(Long orderId, OrderRequestDto orderDto){
        Order order = orderRepo.findById(orderId).get();
        order.updateMenu(orderDto.getMenu());
        order.updateRequest(orderDto.getRequest());
        order.updatePrice(orderDto.getPrice());
        order.updatePlace(orderDto.getPlace());
        orderRepo.save(order);
    }

    public void delete(Long orderId){
        orderRepo.deleteById(orderId);
    }
}
