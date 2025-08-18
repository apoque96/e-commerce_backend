package com.platoons.e_commerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String entity, String property, String value) {
        super(String.format("Could not find %s by %s with the value: %s", entity, property, value));
    }
}
