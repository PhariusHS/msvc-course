package com.luca.springcloud.msvc.courses.UserServices;


import com.luca.springcloud.msvc.courses.Command;
import com.luca.springcloud.msvc.courses.models.Course;
import com.luca.springcloud.msvc.courses.models.CourseDTO;
import com.luca.springcloud.msvc.courses.repositories.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseService implements Command<Course, CourseDTO> {

    private final CourseRepository courseRepository;

    public CreateCourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public ResponseEntity<CourseDTO> execute(Course course){
        Course savedCourse = courseRepository.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CourseDTO(savedCourse));
    }

}
