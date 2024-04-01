package elmo.group.order_microserivce.component;

import elmo.group.order_microserivce.exception.BadRequestException;
import elmo.group.order_microserivce.exception.ForbiddenException;
import elmo.group.order_microserivce.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestExceptionHandler(){
        return new ResponseEntity<>("bad request", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundExceptionHandler(){
        return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(InterruptedException.class)
    public ResponseEntity<?> InternalServerErrorExceptionHandler(){
        return new ResponseEntity<>("internal error", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<?> forbiddenExceptionHandler(){
        return new ResponseEntity<>("forbidden", HttpStatus.FORBIDDEN);
    }
}
