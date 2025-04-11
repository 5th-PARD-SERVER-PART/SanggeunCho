package com.pard.hw3.order.controller;

import com.pard.hw3.order.dto.req.OrderRequestDto;
import com.pard.hw3.order.dto.res.OrderResponseDto;
import com.pard.hw3.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")

public class OrderController {
    private final OrderService orderService;

    @PostMapping("")
    public void save(@RequestBody OrderRequestDto orderDto) {
        orderService.save(orderDto);
    }

    @GetMapping("/{orderID}")
    public OrderResponseDto readById(@PathVariable Long orderId){
        return orderService.read(orderId);
    }

    @GetMapping("/{orderMenu}")
    public ResponseEntity<Long> readByMenu(@RequestParam String menu){
        Long responseValue = orderService.getOrderMenu(menu);

        return new ResponseEntity<>(responseValue, HttpStatus.OK);
    }

    @GetMapping("")
    public List<OrderResponseDto> readAll() {
        return orderService.readAll();
    }

    @GetMapping("/first-jpa")
    public List<OrderResponseDto> readByMenuPlaceGreaterThanPrice(@RequestParam String menu, @RequestParam String place, @RequestParam int price){
        return orderService.findMenuPlaceGreaterThanPrice(menu, place, price);
    }

    @GetMapping("/second-jpa")
    public List<OrderResponseDto> readByPlaceKeywordOfRequest(@RequestParam String place, @RequestParam String keyword){
        return orderService.findPlaceKeywordOfRequest(place, keyword);
    }

    @GetMapping("/third-jpa")
    public List<OrderResponseDto> serachByMenuTimeDesc(@RequestParam String menu, @RequestParam String keyword){
        return orderService.findMenuTimeDesc(menu);
    }

    @PatchMapping("/{orderId}")
    public void update(@PathVariable Long orderId, @RequestParam OrderRequestDto orderDto){
        orderService.update(orderId, orderDto);
    }

    @DeleteMapping("/{orderId}")
    public void delete(@PathVariable Long orderId){
        orderService.delete(orderId);
    }
}
