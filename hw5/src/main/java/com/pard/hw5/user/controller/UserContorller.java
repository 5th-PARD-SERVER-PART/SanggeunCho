package com.pard.hw5.user.controller;

import com.pard.hw5.user.dto.UserResDto;
import com.pard.hw5.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")

public class UserContorller {
    private final UserService userService;

    @GetMapping("/{userId}")
    public UserResDto.ReadUser getUser(@PathVariable Long userId) {
        return userService.readUser(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
