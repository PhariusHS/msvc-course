package com.luca.springcloud.msvc.usuarios.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorMessages {

    ENTITY_NOT_FOUND(" Not Found", HttpStatus.NOT_FOUND.value(), "Not entity with ID founded")
    ;

    private final String message;
    private final int status;
    private final String additionalInfo;

    ErrorMessages(String message, int status, String additionalInfo) {
        this.message = message;
        this.status = status;
        this.additionalInfo = additionalInfo;
    }
}