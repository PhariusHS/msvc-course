package com.luca.springcloud.msvc.courses.clients;


import com.luca.springcloud.msvc.courses.models.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "msvc-users", url = "msvc-users:8080/users")
public interface UserClientRest {

    @GetMapping("/{id}")
    UserDTO getUserById(@PathVariable Long id);
    @PostMapping
    UserDTO createUser(@RequestBody UserDTO user);

    @GetMapping("/users-per-course")
    List<UserDTO>  getAllByIds(@RequestParam Iterable<Long> ids);

}
