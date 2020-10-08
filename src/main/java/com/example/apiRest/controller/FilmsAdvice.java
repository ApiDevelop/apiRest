package com.example.apiRest.controller;

import com.example.apiRest.response.Response;
import com.example.apiRest.service.exceptions.FilmsDoesNotExistException;
import com.example.apiRest.service.exceptions.FilmsRegisteredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;

@ControllerAdvice
public class FilmsAdvice {

    Response<String> response = new Response<>();

    @ResponseBody
    @ExceptionHandler(value = FilmsDoesNotExistException.class)
    public ResponseEntity<Response<String>> filmNotFound(FilmsDoesNotExistException exception) {
        response.setErrors(Collections.singletonList(exception.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ResponseBody
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<Response<String>> idNotRegistered(NullPointerException exception) {
        response.setErrors(Collections.singletonList(exception.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ResponseBody
    @ExceptionHandler(value = FilmsRegisteredException.class)
    public ResponseEntity<Response<String>> idNotRegistered(FilmsRegisteredException exception) {
        response.setErrors(Collections.singletonList(exception.getMessage()));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

}
