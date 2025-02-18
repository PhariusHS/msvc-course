package com.luca.springcloud.msvc.courses.services.UserService;

import com.luca.springcloud.msvc.courses.Query;
import com.luca.springcloud.msvc.courses.clients.UserClientRest;
import com.luca.springcloud.msvc.courses.exceptions.EntityNotFoundException;
import com.luca.springcloud.msvc.courses.exceptions.ErrorMessages;
import com.luca.springcloud.msvc.courses.models.UserDTO;
import com.luca.springcloud.msvc.courses.repositories.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class DeleteCourseUserByIdService implements Query<Long, Void> {

    private final CourseRepository courseRepository;

    public DeleteCourseUserByIdService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Long id) {
        courseRepository.deleteCourseUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
