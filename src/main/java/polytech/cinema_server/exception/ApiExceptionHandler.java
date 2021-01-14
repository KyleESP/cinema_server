package polytech.cinema_server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(Exception e) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException e) {
        List<Error> errors = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            Error err = new Error(error.getCode(), error.getDefaultMessage());
            errors.add(err);
        });
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, errors);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(ApiException.class)
    protected ResponseEntity<Object> handleCustomException(ApiException e) {
        Throwable t = e.getCause() != null ? e.getCause() : e;
        ApiError apiError = new ApiError(e.getStatus(), e.getCode(), e.getMessage(), t.getLocalizedMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException e) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e);
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getError());
    }
}
