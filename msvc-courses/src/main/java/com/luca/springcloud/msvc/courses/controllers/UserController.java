package com.luca.springcloud.msvc.courses.controllers;


import com.luca.springcloud.msvc.courses.models.UserDTO;
import com.luca.springcloud.msvc.courses.services.UserService.AssignUserService;
import com.luca.springcloud.msvc.courses.services.UserService.CreateUserService;
import com.luca.springcloud.msvc.courses.services.UserService.DeleteCourseUserByIdService;
import com.luca.springcloud.msvc.courses.services.UserService.RemoveUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final AssignUserService assignUserService;
    private final CreateUserService createUserService;
    private final RemoveUserService removeUserService;
    private final DeleteCourseUserByIdService deleteCourseUserByIdService;

    public UserController(AssignUserService assignUserService, CreateUserService createUserService, RemoveUserService removeUserService, DeleteCourseUserByIdService deleteCourseUserByIdService)
    {
    this.assignUserService = assignUserService;
    this.createUserService = createUserService;
    this.removeUserService = removeUserService;
    this.deleteCourseUserByIdService = deleteCourseUserByIdService;
    }

    @PostMapping("/create/{courseId}")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user, @PathVariable Long courseId){
        return createUserService.execute(user, courseId);
    }

    @PutMapping("/assign/{courseId}")
    public ResponseEntity<UserDTO> assignUserToCourse(@RequestBody UserDTO user, @PathVariable Long courseId){
        return assignUserService.execute(user, courseId);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCourseUserById(@PathVariable Long id){
        return deleteCourseUserByIdService.execute(id);
    }

    @DeleteMapping("/remove/{courseId}")
    public ResponseEntity<Void> deleteUser(@RequestBody UserDTO user, @PathVariable Long courseId){
        return removeUserService.execute(user, courseId);
    }

}
