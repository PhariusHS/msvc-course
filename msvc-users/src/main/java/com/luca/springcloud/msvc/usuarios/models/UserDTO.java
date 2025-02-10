package com.luca.springcloud.msvc.usuarios.models;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String email;

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();

    }

}
