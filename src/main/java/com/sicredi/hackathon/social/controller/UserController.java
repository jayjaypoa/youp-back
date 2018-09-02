package com.sicredi.hackathon.social.controller;

import com.sicredi.hackathon.social.dto.request.LoginRequest;
import com.sicredi.hackathon.social.dto.request.RegisterUserRequest;
import com.sicredi.hackathon.social.dto.response.LoginResponse;
import com.sicredi.hackathon.social.entity.UserEntity;
import com.sicredi.hackathon.social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Void> registerUser(@RequestBody RegisterUserRequest request) {
        userService.insert(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{email}")
    public UserEntity findUserByUsername(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody final LoginRequest request){
        return userService.login(request);
    }

}
