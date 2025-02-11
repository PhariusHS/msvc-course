package com.luca.springcloud.msvc.usuarios.services.UserServices;

import com.luca.springcloud.msvc.usuarios.Command;
import com.luca.springcloud.msvc.usuarios.exceptions.EntityNotUniqueException;
import com.luca.springcloud.msvc.usuarios.exceptions.ErrorMessages;
import com.luca.springcloud.msvc.usuarios.models.User;
import com.luca.springcloud.msvc.usuarios.models.UserDTO;
import com.luca.springcloud.msvc.usuarios.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements Command<User, UserDTO> {

    private final UserRepository userRepository;

    public CreateUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(User user){
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new EntityNotUniqueException(ErrorMessages.ENTITY_NOT_UNIQUE, "email");
        }
        User savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(savedUser));
    }

}
