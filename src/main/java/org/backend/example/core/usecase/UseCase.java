package org.backend.example.core.usecase;

public interface UseCase<INPUT extends UseCase.Input, OUTPUT extends UseCase.Output> {
    interface Input {}
    interface Output {}

    OUTPUT execute(INPUT input);
}
