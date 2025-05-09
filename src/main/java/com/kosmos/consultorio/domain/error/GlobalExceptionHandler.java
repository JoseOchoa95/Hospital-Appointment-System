package com.kosmos.consultorio.domain.error;

import com.kosmos.consultorio.domain.error.exceptions.BadRequestException;
import com.kosmos.consultorio.domain.error.exceptions.NotAcceptableException;
import com.kosmos.consultorio.domain.error.exceptions.NotFoundException;
import com.kosmos.consultorio.domain.error.exceptions.PreconditionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    //CODE: 400
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(BadRequestException exception) {

        Object body;
        if (exception.getErrorBody() != null) {
            body = exception.getErrorBody();
        } else {
            String mensaje = exception.getMessage();
            if (exception.getCause() != null) {
                mensaje = mensaje.concat(" - ").concat(exception.getCause().getMessage());
            }
            body = new Error(HttpStatus.BAD_REQUEST, mensaje);
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(body);
    }

    //CODE: 404
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException exception) {

        Object body;
        if (exception.getErrorBody() != null) {
            body = exception.getErrorBody();
        } else {
            String mensaje = exception.getMessage();
            if (exception.getCause() != null) {
                mensaje = mensaje.concat(" - ").concat(exception.getCause().getMessage());
            }
            body = new Error(HttpStatus.NOT_FOUND, mensaje);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(body);
    }

    //CODE: 406
    @ExceptionHandler(NotAcceptableException.class)
    public ResponseEntity<?> handleNotAcceptableException(NotAcceptableException exception) {
        Object body;
        if (exception.getErrorBody() != null) {
            body = exception.getErrorBody();
        } else {
            String mensaje = exception.getMessage();
            if (exception.getCause() != null) {
                mensaje = mensaje.concat(" - ").concat(exception.getCause().getMessage());
            }
            body = new Error(HttpStatus.NOT_ACCEPTABLE, mensaje);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .contentType(MediaType.APPLICATION_JSON)
                .body(body);
    }

    //CODE: 412
    @ExceptionHandler(PreconditionFailedException.class)
    public ResponseEntity<?> handlePreconditionFailedException(PreconditionFailedException exception) {

        Object body;
        if (exception.getErrorBody() != null) {
            body = exception.getErrorBody();
        } else {
            String mensaje = exception.getMessage();
            if (exception.getCause() != null) {
                mensaje = mensaje.concat(" - ").concat(exception.getCause().getMessage());
            }
            body = new Error(HttpStatus.PRECONDITION_FAILED, mensaje);
        }

        return ResponseEntity
                .status(HttpStatus.PRECONDITION_FAILED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(body);
    }
}
