package com.sicredi.hackathon.social.controller;

import com.sicredi.hackathon.social.dto.request.LoginRequest;
import com.sicredi.hackathon.social.dto.request.RegisterUserRequest;
import com.sicredi.hackathon.social.dto.response.LoginResponse;
import com.sicredi.hackathon.social.entity.UserEntity;
import com.sicredi.hackathon.social.service.UserService;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/inserir", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registerUser(@RequestBody RegisterUserRequest request) {
        userService.insert(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/procurar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)    
    public UserEntity findUserByUsername(@RequestBody JSONObject dados) {
    	String email = dados.get("email").toString();
        return userService.findUserByEmail(email);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody final LoginRequest request){
        return userService.login(request);
    }

}
