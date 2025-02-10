package com.luca.springcloud.msvc.usuarios.services.UserServices;

import com.luca.springcloud.msvc.usuarios.Query;
import com.luca.springcloud.msvc.usuarios.models.User;
import com.luca.springcloud.msvc.usuarios.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllUsersService implements Query<Void, List<User>> {

    private final UserRepository userRepository;

    public GetAllUsersService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<User>> execute(Void unused) {
        List<User> users = userRepository.findAll();
        // If not products found just returns an empty list
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
