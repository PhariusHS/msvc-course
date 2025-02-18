package com.luca.springcloud.msvc.courses.models;

import lombok.Data;

import java.util.List;

@Data
public class CourseDTO {

    private Long id;
    private String name;
    private List<CourseUser> courseUsers;
    private List<UserDTO> users;

    public CourseDTO(Course course){
        this.id = course.getId();
        this.name = course.getName();
        this.courseUsers = course.getCourseUsers();
        this.users = course.getUsers();
    }

}
