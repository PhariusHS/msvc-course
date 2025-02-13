package com.luca.springcloud.msvc.courses.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is necessary")
    @Size(min = 3, message = "Name needs to have at least 3 characters")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // One course can have many users
    @JoinColumn(name = "course_id")
    private List<CourseUser> courseUsers;

    @Transient
    private List<CourseDTO> users;


    public void addCourseUser(CourseUser courseUser){
        courseUsers.add(courseUser);
    }
    public void removeCourseUser(CourseUser courseUser){
        courseUsers.remove(courseUser);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseUser> getCourseUsers() {
        return courseUsers;
    }

    public void setCourseUsers(List<CourseUser> courseUsers) {
        this.courseUsers = courseUsers;
    }

    public List<CourseDTO> getUsers() {
        return users;
    }

    public void setUsers(List<CourseDTO> users) {
        this.users = users;
    }
}
