package com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.in.controller;

import com.ufps.edu.co.backendInmobiliaria.application.service.AdminService;
import com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.in.request.SignUpRequest;
import com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.out.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping(value = "signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignUpRequest request){
        return ResponseEntity.ok(adminService.createAdmin(request));
    }

}
