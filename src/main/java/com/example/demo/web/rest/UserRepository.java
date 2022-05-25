package com.example.demo.web.rest;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRepository {
    private final UserService userService;

    public UserRepository(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity create(@RequestBody User user){
        if(userService.existsByLogin(user.getLogin())){
            return new ResponseEntity("Bu login mavjud", HttpStatus.BAD_REQUEST);
        }
        if (checkPasswordLength(user.getPassword())){
            return new ResponseEntity("Parol uzunligi 4 dan kam", HttpStatus.BAD_REQUEST);
        }
        User result= userService.save(user);
        return ResponseEntity.ok(result);
    }
    private Boolean checkPasswordLength(String password){
        return password.length() >= 4;
    }
}
