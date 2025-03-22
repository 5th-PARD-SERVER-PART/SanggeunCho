package com.pard.server.week3;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {
    @RequestMapping("/path/{name}")
    public String path(@PathVariable("name") String myName) { return "1st path var controller name: " + myName; }

    @RequestMapping("/pathV2/{name}")
    public String pathV2(@PathVariable String name) { return "2nd path var controller name: " + name; }

    @RequestMapping("/pathV3/{name}/{age}")
    public String pathV3(@PathVariable String name, @PathVariable Long age) {
        return "3rd user name: " + name + " age: " + age;
    }
}
