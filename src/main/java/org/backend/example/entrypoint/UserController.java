package org.backend.example.entrypoint;

import org.backend.example.core.usecase.UserGetterUseCase;
import org.backend.example.entrypoint.data.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserGetterUseCase userGetterUseCase;

    public UserController(UserGetterUseCase userGetterUseCase) {
        this.userGetterUseCase = userGetterUseCase;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getById(@PathVariable String id) {
        var input = new UserGetterUseCase.Input(id);
        var output = userGetterUseCase.execute(input);

        return UserResponse.from(output.user());
    }
}
