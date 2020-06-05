package bootcamp.data;

import java.util.Optional;

public class Result<T> {
    private final Status status = null; //FIXME
    private final String message = null; //FIXME
    private final Optional<T> value = null; //FIXME

    //TODO constructor. Use overloading. 3 constructors
    //1. With argument of type T indicating success and the return value. Status is set to success, message to empty string and value to the argument.
    //2. With status and message. value set to empty optional. Status and message set to corresponding arguments.
    //3. No arguments. Implies success with no return value. status set to success, message to empty string and value to empty Optional.

    //TODO getters
}
