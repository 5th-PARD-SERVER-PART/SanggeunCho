package com.pard.server.hw1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VariousRestController {
    // 그냥 리턴하는 거
    @RequestMapping("/hungry")
    public String hungry() {
        return "새벽에 하니깐 겁나 배고프네";
    }

    // url에 입력하는 값을 변수에 넣어서 사용하는 거
    @RequestMapping("/state/{name}/{state}")
    public String state(@PathVariable String name, @PathVariable int state) {
        if(state == 1) {
            return name + "은 현재 " + "기쁘다";
        } else if(state == 2) {
            return name + "은 현재 " + "슬프다";
        } else {
            return name + "은 현재 " + "배고프다";
        }
    }

    // ?를 사용해서 값을 집어 넣어주는 거
    @RequestMapping("/delivery")
    public String delivery(@RequestParam (required = true, defaultValue = "메뉴를 입력하세요") String menu, @RequestParam(required = false, defaultValue = "-1") Integer count) {
        return "메뉴 : " + menu + "/ 시킨 개수 : " + count;
    }
}
