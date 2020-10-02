package com.example.apiRest.controller;

import com.example.apiRest.service.exceptions.FilmsDoesNotExistException;
import com.example.apiRest.service.exceptions.FilmsRegisteredException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FilmsAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = FilmsDoesNotExistException.class)
    public String filmNotFound(FilmsDoesNotExistException exception) {
        return exception.getMessage();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NullPointerException.class)
    public String idNotRegistered(NullPointerException exception) {
        return exception.getMessage();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(value = FilmsRegisteredException.class)
    public String idNotRegistered(FilmsRegisteredException exception) {
        return exception.getMessage();
    }

}
