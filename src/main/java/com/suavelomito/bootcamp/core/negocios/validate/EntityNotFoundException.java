package com.suavelomito.bootcamp.core.negocios.validate;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
