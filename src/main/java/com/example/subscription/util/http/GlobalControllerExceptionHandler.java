package com.example.subscription.util.http;

import com.example.subscription.util.exceptions.InvalidInputException;
import com.example.subscription.util.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Slf4j
@ControllerAdvice
class GlobalControllerExceptionHandler {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public @ResponseBody HttpErrorInfo handleNotFoundExceptions(Exception ex) {

        return createHttpErrorInfo(NOT_FOUND, ex);
    }

    @ResponseStatus(UNPROCESSABLE_ENTITY)
    @ExceptionHandler(InvalidInputException.class)
    public @ResponseBody HttpErrorInfo handleInvalidInputException(Exception ex) {
        return createHttpErrorInfo(UNPROCESSABLE_ENTITY, ex);
    }

    private HttpErrorInfo createHttpErrorInfo(HttpStatus httpStatus, Exception ex) {
        final String message = ex.getMessage();

        log.info("Returning Error HTTP status: {}, message: {}", httpStatus, message);
        return new HttpErrorInfo(httpStatus, message);
    }
}