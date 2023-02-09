package com.example.jan2023.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/greet")
    public String sayHello(){
        return "WELCOME TO THE SPRINGBOOT FRAMEWORK";
    }

    @GetMapping("/greet/{name}")
    public String sayHelloWithName(@PathVariable("name") String inputName){
        return "HI "+inputName+", WELCOME TO SPRINGBOOT FRAMEWORK";
    }

    @GetMapping("/greeting")
    public String sayHelloWithRequestParam(@RequestParam("name") String inputName){
        return "HI "+inputName+", WELCOME TO SPRINGBOOT FRAMEWORK - REQUEST PARAM";
    }
}
