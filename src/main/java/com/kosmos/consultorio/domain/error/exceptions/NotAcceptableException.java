package com.kosmos.consultorio.domain.error.exceptions;

public class NotAcceptableException extends RuntimeException {

    public Object errorBody;

    public NotAcceptableException() {
        super();
    }

    public NotAcceptableException(String message) {
        super(message);
    }

    public NotAcceptableException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAcceptableException(Throwable cause) {
        super(cause);
    }

    public NotAcceptableException(String message, Object errorBody) {
        super(message);
        this.errorBody = errorBody;
    }

    public Object getErrorBody() {
        return errorBody;
    }

    public void setErrorBody(Object errorBody) {
        this.errorBody = errorBody;
    }
}
