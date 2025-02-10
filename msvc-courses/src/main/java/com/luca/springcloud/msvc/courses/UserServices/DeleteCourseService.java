package com.luca.springcloud.msvc.courses.UserServices;



import com.luca.springcloud.msvc.courses.Command;
import com.luca.springcloud.msvc.courses.models.Course;
import com.luca.springcloud.msvc.courses.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteCourseService implements Command<Long, Void> {

    private final CourseRepository courseRepository;

    public DeleteCourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Long id) {
        Optional<Course> foundedUser = courseRepository.findById(id);
        if(foundedUser.isPresent()){
            courseRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new EntityNotFoundException("Not user with id "+ id +" founded");
    }
}
