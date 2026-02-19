package com.store.infrastructure.config;

import com.store.domain.enums.Role;
import com.store.domain.model.User;
import com.store.domain.ports.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component @RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final UserPort userPort;
    private final PasswordEncoder passwordEncoder;
    @Override public void run(String... args) {
        if (userPort.findByUsername("admin").isEmpty()) {
            userPort.save(User.builder().username("admin").password(passwordEncoder.encode("admin123")).role(Role.ROLE_ADMIN).build());
        }
    }
}
