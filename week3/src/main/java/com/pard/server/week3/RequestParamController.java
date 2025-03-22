package com.pard.server.week3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
public class RequestParamController {
    @RequestMapping("/v1")
    public String param1(@RequestParam("name") String myName, @RequestParam("age") int myAge){
        return "Request Param 1: " + myName + " age: " + myAge;
    }

    @RequestMapping("/v2")
    public String param2(@RequestParam String name, @RequestParam int age){
        return "2nd param name: " + name + " age: " + age;
    }

    // 비추하는 방법 -> 뜨긴함
    @RequestMapping("/v3")
    public String param3(String name, int age) {
        return "3rd param name: " + name + " age: " + age;
    }

    @RequestMapping("/v4")
    public String param4(@RequestParam String name, @RequestParam(required = false) Integer age){
        if(age == null){
            return "4th param: " + name + " age: 입력값 없음";
        }
        return "4th param: " + name + " age: " + age;
    }

    // required가 false면 이 값을 넣지 않아도 null 값으로 출력함 -> no error
    @RequestMapping("/v5")
    public String param5(@RequestParam (required = true, defaultValue = "파드") String name, @RequestParam(required =false, defaultValue = "-1") Integer age){
        return "5th param: " + name + " age: " + age;
    }

    // 비추 방법
    @RequestMapping("/v6")
    public String param6(@RequestParam Map<String, Objects> map){
        return "6th param: " + map.get("name") + map.get("age");
    }

}
