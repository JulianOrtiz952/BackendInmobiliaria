package com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.in.controller;

import com.ufps.edu.co.backendInmobiliaria.application.service.AuthService;
import com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.in.request.LoginRequest;
import com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.in.request.SignUpRequest;
import com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.out.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping(value = "signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignUpRequest request){
        return ResponseEntity.ok(authService.signUp(request));
    }

}
