package com.pard.hw2.user.repository;

import com.pard.hw2.user.dto.PizzaDto;
import com.pard.hw2.user.entity.Pizza;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

public class PizzaRepository {
    private static final Map<Integer, Pizza> order = new HashMap<>();

    public void save(PizzaDto pizzaDto) {
        Pizza pizza = Pizza.builder()
                .pizzaID(pizzaDto.getPizzaID())
                .pizzaName(pizzaDto.getPizzaName())
                .pizzaPrice(pizzaDto.getPizzaPrice())
                .pizzaEdge(pizzaDto.getPizzaEdge())
                .build();
            order.put(pizzaDto.getPizzaID(), pizza);
    }

    public PizzaDto findByID(int pizzaID){
        Pizza pizza = order.get(pizzaID);

        return PizzaDto.builder()
                .pizzaID(pizza.getPizzaID())
                .pizzaName(pizza.getPizzaName())
                .pizzaPrice(pizza.getPizzaPrice())
                .pizzaEdge(pizza.getPizzaEdge())
                .build();
    }

    public void updateByID(int pizzaID, PizzaDto pizzaDto) {
        Pizza pizza = order.get(pizzaID);

        pizza.setPizzaID(pizzaDto.getPizzaID());
        pizza.setPizzaName(pizzaDto.getPizzaName());
        pizza.setPizzaPrice(pizzaDto.getPizzaPrice());
        pizza.setPizzaEdge(pizzaDto.getPizzaEdge());
    }

    public void delete(int pizzaID){
        order.remove(pizzaID);
    }

    public List<PizzaDto> findAll(){
        return order.values().stream()
                .map(pizza -> PizzaDto.builder()
                        .pizzaID(pizza.getPizzaID())
                        .pizzaName(pizza.getPizzaName())
                        .pizzaPrice(pizza.getPizzaPrice())
                        .pizzaEdge(pizza.getPizzaEdge())
                        .build()).toList();
    }
}
