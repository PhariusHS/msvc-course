package com.luca.springcloud.msvc.courses.services.CourseServices;


import com.luca.springcloud.msvc.courses.Query;
import com.luca.springcloud.msvc.courses.exceptions.EntityNotFoundException;
import com.luca.springcloud.msvc.courses.exceptions.ErrorMessages;
import com.luca.springcloud.msvc.courses.models.Course;
import com.luca.springcloud.msvc.courses.models.CourseDTO;
import com.luca.springcloud.msvc.courses.repositories.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCourseByIdService implements Query<Long, CourseDTO> {

    private final CourseRepository courseRepository;

    public GetCourseByIdService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public ResponseEntity<CourseDTO> execute(Long id) {
        Optional<Course> foundedCourse = courseRepository.findById(id);
        if(foundedCourse.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new CourseDTO(foundedCourse.get()));
        }
        throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "Course");
    }
}
