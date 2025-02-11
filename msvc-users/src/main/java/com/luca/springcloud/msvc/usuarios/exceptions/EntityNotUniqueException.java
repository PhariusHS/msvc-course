package com.luca.springcloud.msvc.usuarios.exceptions;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityNotUniqueException extends RuntimeException{

    private final int status;
    private final String additionalInfo;

    public EntityNotUniqueException(ErrorMessages errorMessages, String value){
        super(ErrorMessages.ENTITY_NOT_UNIQUE.getMessage() + value );
        this.status = errorMessages.getStatus();
        this.additionalInfo = errorMessages.getAdditionalInfo();
    }
}
