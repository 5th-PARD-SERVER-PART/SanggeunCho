package com.pard.hw4.user.controller;

import com.pard.hw4.user.dto.UserReqDto;
import com.pard.hw4.user.dto.UserResDto;
import com.pard.hw4.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public UserResDto.ReadUser getUser(@PathVariable Long userId) {
        return userService.readUser(userId);
    }

    @PostMapping("")
    public void createUser(@RequestBody UserReqDto.UserCreateRequest req){
        userService.createUser(req);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
