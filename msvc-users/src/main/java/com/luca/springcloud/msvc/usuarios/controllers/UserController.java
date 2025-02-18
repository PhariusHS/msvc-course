package com.luca.springcloud.msvc.usuarios.controllers;


import com.luca.springcloud.msvc.usuarios.models.User;
import com.luca.springcloud.msvc.usuarios.models.UserDTO;
import com.luca.springcloud.msvc.usuarios.services.UserServices.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final GetAllUsersService getAllUsersService;
    private final GetUserByIdService getUserByIdService;
    private final CreateUserService  createUserService;
    private final DeleteUserService  deleteUserService;
    private final GetAllByIdsService getAllByIdsService;

    public UserController(GetAllUsersService getAllUsersService,
        GetUserByIdService getUserByIdService,
        CreateUserService  createUserService,
        DeleteUserService  deleteUserService,
                          GetAllByIdsService getAllByIdsService)
    {

        this.getAllUsersService = getAllUsersService;
        this.getUserByIdService = getUserByIdService;
        this.createUserService = createUserService;
        this.deleteUserService = deleteUserService;
        this.getAllByIdsService = getAllByIdsService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return getAllUsersService.execute(null);
    }

    @GetMapping("/users-per-course")
    public List<User> getAllByIds(@RequestParam List<Long> ids){
        return getAllByIdsService.execute(ids);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        return getUserByIdService.execute(id);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user){
        return createUserService.execute(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        return deleteUserService.execute(id);
    }


}
