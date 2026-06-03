package com.ecommerce.ecommercebackend.controller;

import com.ecommerce.ecommercebackend.dto.AuthRequest;
import com.ecommerce.ecommercebackend.dto.AuthResponse;
import com.ecommerce.ecommercebackend.dto.RegisterRequest;
import com.ecommerce.ecommercebackend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
