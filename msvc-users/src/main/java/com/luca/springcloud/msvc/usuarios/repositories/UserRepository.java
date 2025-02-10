package com.luca.springcloud.msvc.usuarios.repositories;

import com.luca.springcloud.msvc.usuarios.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
