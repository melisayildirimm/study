package yte.intern.spring_web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")

    public ResponseEntity<Student> student(){
        return ResponseEntity.status(202).
                header("hatavarmi","false").
                body(new Student("Melisa",26,"hebele@hubele.com"));
    }

}