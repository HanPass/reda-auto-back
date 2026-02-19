package com.store.domain.ports;

import com.store.domain.model.User;
import java.util.Optional;

public interface UserPort {
    User save(User user);
    Optional<User> findByUsername(String username);
}
