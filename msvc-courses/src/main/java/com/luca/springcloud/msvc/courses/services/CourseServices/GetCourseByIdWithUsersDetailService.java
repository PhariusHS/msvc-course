package com.luca.springcloud.msvc.courses.services.CourseServices;


import com.luca.springcloud.msvc.courses.Query;
import com.luca.springcloud.msvc.courses.clients.UserClientRest;
import com.luca.springcloud.msvc.courses.exceptions.EntityNotFoundException;
import com.luca.springcloud.msvc.courses.exceptions.ErrorMessages;
import com.luca.springcloud.msvc.courses.models.Course;
import com.luca.springcloud.msvc.courses.models.CourseDTO;
import com.luca.springcloud.msvc.courses.models.CourseUser;
import com.luca.springcloud.msvc.courses.models.UserDTO;
import com.luca.springcloud.msvc.courses.repositories.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetCourseByIdWithUsersDetailService implements Query<Long, CourseDTO> {

    private final CourseRepository courseRepository;
    private final UserClientRest userClientRest;

    public GetCourseByIdWithUsersDetailService(CourseRepository courseRepository, UserClientRest userClientRest){
        this.courseRepository = courseRepository;
        this.userClientRest = userClientRest;
    }

    @Override
    public ResponseEntity<CourseDTO> execute(Long id) {
        Optional<Course> foundedCourse = courseRepository.findById(id);
        if(foundedCourse.isPresent()){
            Course existingCourse = foundedCourse.get();
            if(!existingCourse.getCourseUsers().isEmpty()){
             List<Long> ids = existingCourse.getCourseUsers().stream().map(CourseUser::getUserId).toList();
             List<UserDTO> users = userClientRest.getAllByIds(ids);
             existingCourse.setUsers(users);
            }
            return ResponseEntity.status(HttpStatus.OK).body(new CourseDTO(existingCourse));
        }
        throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "Course");
    }
}
