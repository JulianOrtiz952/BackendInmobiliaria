package com.ufps.edu.co.backendInmobiliaria.application.service;

import com.ufps.edu.co.backendInmobiliaria.domain.extra.Role;
import com.ufps.edu.co.backendInmobiliaria.domain.entity.User;
import com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.in.request.LoginRequest;
import com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.in.request.SignUpRequest;
import com.ufps.edu.co.backendInmobiliaria.domain.dao.UserRepository;
import com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.out.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse signUp(SignUpRequest request) {

        var user = User.builder()
                .name(request.getName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);


        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}