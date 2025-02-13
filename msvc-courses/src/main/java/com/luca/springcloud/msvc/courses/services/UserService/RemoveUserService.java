package com.luca.springcloud.msvc.courses.services.UserService;

import com.luca.springcloud.msvc.courses.RelationalCommand;
import com.luca.springcloud.msvc.courses.clients.UserClientRest;
import com.luca.springcloud.msvc.courses.exceptions.EntityNotFoundException;
import com.luca.springcloud.msvc.courses.exceptions.ErrorMessages;
import com.luca.springcloud.msvc.courses.models.Course;
import com.luca.springcloud.msvc.courses.models.CourseUser;
import com.luca.springcloud.msvc.courses.models.UserDTO;
import com.luca.springcloud.msvc.courses.repositories.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class RemoveUserService implements RelationalCommand<UserDTO, Long, Void> {


    private final CourseRepository courseRepository;
    private final UserClientRest userClientRest;

    public RemoveUserService(CourseRepository courseRepository, UserClientRest userClientRest){
        this.courseRepository = courseRepository;
        this.userClientRest = userClientRest;
    }

    @Override
    public ResponseEntity<Void> execute(UserDTO userDTO, Long courseId) {
        Optional<Course> foundedCourse = courseRepository.findById(courseId);

        if(foundedCourse.isPresent()){
            UserDTO msvcUser = userClientRest.getUserById(userDTO.getId());

            Course updatedCourse = foundedCourse.get();
            CourseUser courseUser = new CourseUser();
            courseUser.setUserId(msvcUser.getId());
            updatedCourse.removeCourseUser(courseUser);
            courseRepository.save(updatedCourse);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "Course");
    }
}
