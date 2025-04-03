package com.pard.seminar2.user.controller;

import com.pard.seminar2.user.dto.UserDto;
import com.pard.seminar2.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // final로 선언된 모든 필드에 대해 생성자를 만듦
@RequestMapping("/user")

public class UserController {
    private final UserService userService;
    // 바뀌면 위험하니 final

    @PostMapping("")
    public String save (@RequestBody UserDto userDto) {
        // RequestBody는 컨트롤러에서 client와 데이타 주고받을 때 사용하는 어노테이션
        // json으로 알아서 주고 받음
        userService.saveUser(userDto);
        return "저장완료";
    }

    @GetMapping("/{studentID}")
    public UserDto findByID(@PathVariable Long studentID) {
        // 조회이기 때문에 String이 아닌 UserDto의 형식으로 넘겨줌
        return userService.findByID(studentID);
    }

    @PatchMapping("/{studentID}")
    public String updateByID(@PathVariable Long studentID, @RequestBody UserDto userDto) {
        userService.updateByID(studentID, userDto);

        return "수정완료";
    }

    @DeleteMapping("/{studentID}")
    public String delete(@PathVariable Long studentID) {
        userService.delete(studentID);

        return "삭제완료";
    }

    @GetMapping("")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

}
