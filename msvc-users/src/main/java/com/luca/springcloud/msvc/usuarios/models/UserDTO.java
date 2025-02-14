package com.luca.springcloud.msvc.usuarios.models;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String password;

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();

    }

}
