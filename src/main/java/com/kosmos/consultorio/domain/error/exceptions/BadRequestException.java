package com.kosmos.consultorio.domain.error.exceptions;

public class BadRequestException extends RuntimeException {

    public Object errorBody;

    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    public BadRequestException(String message, Object errorBody) {
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