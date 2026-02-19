package com.store.infrastructure.security;

import com.store.application.exception.NotFoundException;
import com.store.domain.ports.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserPort userPort;
    @Override public UserDetails loadUserByUsername(String username) {
        var u = userPort.findByUsername(username).orElseThrow(() -> new NotFoundException("Utilisateur introuvable"));
        return new User(u.getUsername(), u.getPassword(), java.util.List.of(new SimpleGrantedAuthority(u.getRole().name())));
    }
}
