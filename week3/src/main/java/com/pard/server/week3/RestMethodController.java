package com.pard.server.week3;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class RestMethodController {
    @GetMapping("")
    public String getUsers() { return "Get Method controller"; }

    @PostMapping("")
    public String postUsers() { return "add users to DB"; }

    @GetMapping("/{userId}")
    public String getUserByID(@PathVariable Long userId) { return userId + "# user id updated"; }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId) { return userId + "# user id deleted"; }
}
