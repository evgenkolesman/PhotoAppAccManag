package ru.koleson.photoappaccmanag.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception e, WebRequest req) {

        String exceptionMessageDescription = e.getLocalizedMessage();

        if (exceptionMessageDescription == null) {
            exceptionMessageDescription = e.toString();
        }
        ExceptionMessage ex = new ExceptionMessage(new Date(), exceptionMessageDescription);
        return new ResponseEntity<>(
                ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class, AccountException.class})
    public ResponseEntity<Object> handleSpecificExceptionException(Exception e, WebRequest req) {

        String exceptionMessageDescription = e.getLocalizedMessage();

        if (exceptionMessageDescription == null) {
            exceptionMessageDescription = e.toString();
        }
        ExceptionMessage ex = new ExceptionMessage(new Date(), exceptionMessageDescription);
        return new ResponseEntity<>(
                ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
