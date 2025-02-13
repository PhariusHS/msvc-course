package com.luca.springcloud.msvc.courses.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "course_user")
@Data
public class CourseUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", unique = true)
    private Long userId;


    @Override
    public boolean equals(Object obj){ // compare with id
        if (this == obj){
            return true;
        }
        if(!(obj instanceof CourseUser)){
            return false;
        }
        CourseUser courseUser = (CourseUser) obj;
        return this.userId != null && this.userId.equals(courseUser.userId);
    }


}
