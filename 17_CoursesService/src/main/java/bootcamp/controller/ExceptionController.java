package bootcamp.controller;

import bootcamp.persistencemock.NotFoundException;
import org.springframework.http.ResponseEntity;

// TODO Controller Advice annotation
public class ExceptionController /* TODO extend the  ResponseEntityExceptionHandler */{
    // TODO Exception handler annotation specifying NotFoundException class.
    // TODO Create a class to encapsulate the error details and use that with ResponseEntity to return the following,
    // TODO 1. Error message, 2. Timestamp
    public ResponseEntity<?> handleNotFound(final NotFoundException exp) {
        return null; //FIXME
    }
}
