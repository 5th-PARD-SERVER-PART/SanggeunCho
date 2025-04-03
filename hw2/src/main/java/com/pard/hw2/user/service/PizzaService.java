package com.pard.hw2.user.service;

import com.pard.hw2.user.dto.PizzaDto;
import com.pard.hw2.user.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public void savePizza(PizzaDto pizzaDto) {
        pizzaRepository.save(pizzaDto);
    }

    public PizzaDto findByID(int pizzaID){
        return pizzaRepository.findByID(pizzaID);
    }

    public void updateByID(int pizzaID, PizzaDto pizzaDto) {
        pizzaRepository.updateByID(pizzaID, pizzaDto);
    }

    public void delete(int pizzaID){
        pizzaRepository.delete(pizzaID);
    }

    public List<PizzaDto> findAll(){
        return pizzaRepository.findAll();
    }
}
