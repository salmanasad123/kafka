package com.embarkx.FirstSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping(value = "hello")
    public String helloPost(@RequestBody String name) {
        return "Hello " + name;
    }
}
