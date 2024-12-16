package org.backend.example.core.repository;

import org.backend.example.core.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(String id);


}
