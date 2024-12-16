package org.backend.example.core.usecase;

import org.backend.example.core.entity.User;
import org.backend.example.core.exception.UserNotFoundException;
import org.backend.example.core.repository.UserRepository;

import javax.inject.Named;

@Named
public class UserGetterUseCase implements UseCase<UserGetterUseCase.Input, UserGetterUseCase.Output> {
    private final UserRepository userRepository;

    public UserGetterUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Output execute(Input input) {
        var user = userRepository.findById(input.id);

        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }

        return new Output(user.get());
    }

    public record Input(String id) implements UseCase.Input {}

    public record Output(User user) implements UseCase.Output {}
}
