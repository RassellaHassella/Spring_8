package ru.kata.spring.boot_security.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@org.springframework.stereotype.Controller

public class Controller {
    @GetMapping("/hello")
        public String sayHello(){
        return "hello";
    }
}
