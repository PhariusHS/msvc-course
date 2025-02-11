package com.luca.springcloud.msvc.courses.models;

import lombok.Data;

@Data
public class CourseDTO {

    private Long id;
    private String name;

    public CourseDTO(Course course){
        this.id = course.getId();
        this.name = course.getName();
    }

}
