package com.luca.springcloud.msvc.courses.services.CourseServices;

import com.luca.springcloud.msvc.courses.Query;
import com.luca.springcloud.msvc.courses.models.Course;
import com.luca.springcloud.msvc.courses.repositories.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCoursesService implements Query<Void, List<Course>> {

    private final CourseRepository courseRepository;

    public GetAllCoursesService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public ResponseEntity<List<Course>> execute(Void unused) {
        List<Course> courses = courseRepository.findAll();
        // If not products found just returns an empty list
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }
}
