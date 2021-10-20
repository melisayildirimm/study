package yte.intern.spring_web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @PostMapping("/user")
    public User user(@Valid @RequestBody User user){
        System.out.println(user);
        return user;
    }
}
