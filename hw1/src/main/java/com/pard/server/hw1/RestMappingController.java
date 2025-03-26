package com.pard.server.hw1;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chicken")
public class RestMappingController {
    @GetMapping("")
    public String getChickens() {
        return "Get Chicken's info";
    }

    @PostMapping("")
    public String postChickens() {
        return "Post Chickens's info";
    }

    @GetMapping("/{chickenId}")
    public String getChickenByID(@PathVariable Integer chickenId) {
        return chickenId + "# chicken is for you";
    }

    @DeleteMapping("/{chickenId}")
    public String deleteChicken(@PathVariable Integer chickenId) {
        return chickenId + "# chicken is not yours";
    }

}
