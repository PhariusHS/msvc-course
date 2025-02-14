package com.luca.springcloud.msvc.courses.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;

    public UserDTO(UserDTO userDTO){
        this.id = userDTO.getId();
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
    }
}
