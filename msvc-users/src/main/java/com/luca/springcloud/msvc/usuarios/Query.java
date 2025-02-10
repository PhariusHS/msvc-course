package com.luca.springcloud.msvc.usuarios;

import org.springframework.http.ResponseEntity;

public interface Query<Input, Output> {
    ResponseEntity<Output> execute(Input input);
}
