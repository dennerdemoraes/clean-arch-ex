package org.backend.example.gateway;

import org.backend.example.core.entity.User;
import org.backend.example.core.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserGatewayRepository implements UserRepository {
    @Override
    public Optional<User> findById(String id) {
        return Optional.of(new User("1234", "Taylor Swift", 30));
    }
}
