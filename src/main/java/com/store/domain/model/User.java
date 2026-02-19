package com.store.domain.model;

import com.store.domain.enums.Role;
import lombok.*;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private Role role;
    private Long version;
}
