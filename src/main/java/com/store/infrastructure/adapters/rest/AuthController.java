package com.store.infrastructure.adapters.rest;

import com.store.application.dto.LoginRequest;
import com.store.application.dto.LoginResponse;
import com.store.infrastructure.security.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/auth") @RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login") public LoginResponse login(@Valid @RequestBody LoginRequest request){ return authService.login(request); }
}
