package polytech.cinema_server.exception;

public class Error {

    private String code;
    private String message;
    private String debugMessage;

    Error(Throwable t) {
        this.message = t.getMessage();
        if (!message.equals(t.getLocalizedMessage()))
            this.debugMessage = t.getLocalizedMessage();
    }

    Error(String code, String message) {
        this.code = code;
        this.message = message;
    }

    Error(String code, String message, String debugMessage) {
        this.code = code;
        this.message = message;
        if (!message.equals(debugMessage))
            this.debugMessage = debugMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }
}
