package yte.intern.spring_web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @PostMapping("/person")
    public List<Person> incrementAge(@RequestBody List<Person> people){
        for(Person person:people){
            person.incrementAge();
        }
        return people;
    }
}
