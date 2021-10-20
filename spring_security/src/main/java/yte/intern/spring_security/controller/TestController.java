package yte.intern.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/name")
    public String getName(){
        return "Melisa Yıldırım";
    }

}
