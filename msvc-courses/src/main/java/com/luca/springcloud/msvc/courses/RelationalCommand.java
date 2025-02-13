package com.luca.springcloud.msvc.courses;

import org.springframework.http.ResponseEntity;

public interface RelationalCommand<Input, SecondInput, Output> {
    ResponseEntity<Output> execute(Input input, SecondInput secondInput);
}