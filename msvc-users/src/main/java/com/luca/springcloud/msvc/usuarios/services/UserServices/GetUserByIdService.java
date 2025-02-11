package com.luca.springcloud.msvc.usuarios.services.UserServices;

import com.luca.springcloud.msvc.usuarios.Query;
import com.luca.springcloud.msvc.usuarios.exceptions.EntityNotFoundException;
import com.luca.springcloud.msvc.usuarios.exceptions.ErrorMessages;
import com.luca.springcloud.msvc.usuarios.models.User;
import com.luca.springcloud.msvc.usuarios.models.UserDTO;
import com.luca.springcloud.msvc.usuarios.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserByIdService implements Query<Long, UserDTO> {

    private final UserRepository userRepository;

    public GetUserByIdService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(Long id) {
        Optional<User> foundedUser = userRepository.findById(id);
        if(foundedUser.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new UserDTO(foundedUser.get()));
        }
        throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "User");
    }
}
