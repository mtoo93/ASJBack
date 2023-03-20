package com.suavelomito.bootcamp.core.negocios.validate;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
