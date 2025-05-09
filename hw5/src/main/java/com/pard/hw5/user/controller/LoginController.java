package com.pard.hw5.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/loginForm")
    public String login() {
        return "loginForm";
    }

    @GetMapping("/login-success")
    public String loginSuccess() {
        return "login-success";
    }
}
