package com.hotel.hotel.review.controller;

import com.hotel.hotel.review.dto.LoginRequest;
import com.hotel.hotel.review.dto.RegisterRequest;
import com.hotel.hotel.review.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String token = userService.login(request);
        return ResponseEntity.ok().body("Bearer " + token);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        String token = userService.register(request);
        return ResponseEntity.ok().body("Bearer " + token);
    }
}
