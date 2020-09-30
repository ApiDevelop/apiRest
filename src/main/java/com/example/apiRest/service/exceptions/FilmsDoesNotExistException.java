package com.example.apiRest.service.exceptions;

public class FilmsDoesNotExistException extends RuntimeException {

    public FilmsDoesNotExistException(String message) {
        super(message);
    }
}
