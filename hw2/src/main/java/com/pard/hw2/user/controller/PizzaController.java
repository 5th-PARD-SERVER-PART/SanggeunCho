package com.pard.hw2.user.controller;

import com.pard.hw2.user.dto.PizzaDto;
import com.pard.hw2.user.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizza")

public class PizzaController {
    private final PizzaService pizzaService;

    @PostMapping("")
    public String save (@RequestBody PizzaDto pizzaDto){
        pizzaService.savePizza(pizzaDto);

        return "피자 만듦~";
    }

    @GetMapping("/{pizzaID}")
    public PizzaDto findByID(@PathVariable int pizzaID){
        return pizzaService.findByID(pizzaID);
    }

    @PatchMapping("/{pizzaID}")
    public String updateByID(@PathVariable int pizzaID, @RequestBody PizzaDto pizzaDto){
        pizzaService.updateByID(pizzaID, pizzaDto);

        return "피자 고침~";
    }

    @DeleteMapping("/{pizzaID}")
    public String delete(@PathVariable int pizzaID){
        pizzaService.delete(pizzaID);

        return "피자 없어짐 ㅠ";
    }

    @GetMapping("")
    public List<PizzaDto> findAll(){
        return pizzaService.findAll();
    }
}
