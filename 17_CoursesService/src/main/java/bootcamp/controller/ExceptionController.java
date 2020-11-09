package bootcamp.controller;

import bootcamp.persistencemock.NotFoundException;
import org.springframework.http.ResponseEntity;

// TODO Controller Advice annotation
public class ExceptionController /* TODO extend the  ResponseEntityExceptionHandler */{
    // TODO Exception handler annotation specifying NotFoundException class.
    public ResponseEntity<String> handleNotFound(final NotFoundException exp) {
        return null; //FIXME
    }
}
