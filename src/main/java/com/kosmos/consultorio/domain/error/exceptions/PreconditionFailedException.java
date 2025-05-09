package com.kosmos.consultorio.domain.error.exceptions;

public class PreconditionFailedException extends RuntimeException{

    public Object errorBody;

    public PreconditionFailedException() {
        super();
    }

    public PreconditionFailedException(String message) {
        super(message);
    }

    public PreconditionFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PreconditionFailedException(Throwable cause) {
        super(cause);
    }

    public PreconditionFailedException(String message, Object errorBody) {
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
