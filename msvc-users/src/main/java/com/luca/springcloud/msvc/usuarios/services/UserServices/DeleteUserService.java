package com.luca.springcloud.msvc.usuarios.services.UserServices;

import com.luca.springcloud.msvc.usuarios.Command;
import com.luca.springcloud.msvc.usuarios.clients.CourseClientRest;
import com.luca.springcloud.msvc.usuarios.exceptions.EntityNotFoundException;
import com.luca.springcloud.msvc.usuarios.exceptions.ErrorMessages;
import com.luca.springcloud.msvc.usuarios.models.User;
import com.luca.springcloud.msvc.usuarios.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteUserService implements Command<Long, Void> {

    private final UserRepository userRepository;
    private final CourseClientRest courseClientRest;

    public DeleteUserService(UserRepository userRepository, CourseClientRest courseClientRest){
        this.userRepository = userRepository;
        this.courseClientRest = courseClientRest;
    }

    @Override
    public ResponseEntity<Void> execute(Long id) {
        Optional<User> foundedUser = userRepository.findById(id);
        if(foundedUser.isPresent()){
            userRepository.deleteById(id);
            courseClientRest.deleteCourseUserById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "User");
    }
}
