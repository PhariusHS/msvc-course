package com.luca.springcloud.msvc.usuarios.services.UserServices;

import com.luca.springcloud.msvc.usuarios.models.User;
import com.luca.springcloud.msvc.usuarios.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllByIdsService {

   private final UserRepository userRepository;

   public GetAllByIdsService(UserRepository userRepository){
       this.userRepository = userRepository;
   }

   public List<User> execute(Iterable<Long> ids) {
   return userRepository.findAllById(ids);
   }
}
