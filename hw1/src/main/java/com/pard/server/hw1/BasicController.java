package com.pard.server.hw1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {
    @RequestMapping("/home")
    public String home() {
        return "home.html";
    }
}
