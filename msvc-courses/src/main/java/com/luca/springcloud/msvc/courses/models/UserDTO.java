package com.luca.springcloud.msvc.courses.models;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;

    public UserDTO(UserDTO userDTO){
        this.id = userDTO.getId();
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();

    }

}
