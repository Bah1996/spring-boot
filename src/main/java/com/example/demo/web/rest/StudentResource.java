package com.example.demo.web.rest;

import com.example.demo.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentResource {
    @GetMapping("/students")
    public ResponseEntity hello(){
        return  ResponseEntity.ok("Dfdfd");
    }
    @PostMapping("/students")
    public ResponseEntity create(@RequestBody Student student){
        return ResponseEntity.ok(student);

    }
}
