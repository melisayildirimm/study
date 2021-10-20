package yte.intern.spring_web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PreDestroy;

@Controller
public class WelcomeController {

    @RequestMapping("/welcome")
    public String init(){
        return "welcome.html";
    }


    @RequestMapping("/welcome/{number}")
    public void init(@PathVariable Long number, @RequestParam String name, @RequestParam String surname) {
        System.out.println(number + name + surname);
        System.out.println("jdfhvkdfh");

    }

}

