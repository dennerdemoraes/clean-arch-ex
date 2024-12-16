package org.backend.example.entrypoint.data;

import org.backend.example.core.entity.User;

public record UserResponse(
        String name,
        Integer age
) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.name(),
                user.age()
        );
    }
}
