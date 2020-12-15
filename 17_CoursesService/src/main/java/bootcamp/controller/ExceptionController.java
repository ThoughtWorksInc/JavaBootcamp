package bootcamp.controller;


import bootcamp.persistencemock.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFound(final NotFoundException exp) {
        RestErrorResponse restErrorResponse = new RestErrorResponse(exp, "Entity not found");
        return new ResponseEntity<>(restErrorResponse, HttpStatus.NOT_FOUND);
    }

    static class RestErrorResponse {
        private final long timestamp;
        private final Throwable cause;
        private final String message;


        RestErrorResponse(Throwable cause, String message) {
            this.timestamp = System.currentTimeMillis();
            this.cause = cause;
            this.message = message;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public Throwable getCause() {
            return cause;
        }

        public String getMessage() {
            return message;
        }
    }
}
