package com.luca.springcloud.msvc.courses.clients;


import com.luca.springcloud.msvc.courses.models.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msvc-users", url = "localhost:8080/users")
public interface UserClientRest {

    @GetMapping("/{id}")
    UserDTO getUserById(@PathVariable Long id);
    @PostMapping
    UserDTO createUser(@RequestBody UserDTO user);


}
