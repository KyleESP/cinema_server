package polytech.cinema_server.exception;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ApiError {

    private int status;
    private HttpStatus error;
    private Timestamp timestamp;
    private List<Error> errors;

    ApiError(HttpStatus status) {
        errors = new ArrayList<>();
        this.status = status.value();
        this.error = status;
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    ApiError(HttpStatus status, Error err) {
        this(status);
        errors.add(err);
    }

    ApiError(HttpStatus status, List<Error> errors) {
        this(status);
        this.errors = errors;
    }

    ApiError(HttpStatus status, String code, String message, String debugMessage) {
        this(status, new Error(code, message, debugMessage));
    }

    ApiError(HttpStatus status, Throwable t) {
        this(status, new Error(t));
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public HttpStatus getError() {
        return error;
    }

    public void setError(HttpStatus error) {
        this.error = error;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}