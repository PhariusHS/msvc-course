package com.luca.springcloud.msvc.courses.controllers;


import com.luca.springcloud.msvc.courses.services.CourseServices.*;
import com.luca.springcloud.msvc.courses.models.Course;
import com.luca.springcloud.msvc.courses.models.CourseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final GetAllCoursesService getAllCoursesService;
    private final GetCourseByIdService getCourseByIdService;
    private final CreateCourseService createCourseService;
    private final DeleteCourseService deleteCourseService;
    private final GetCourseByIdWithUsersDetailService getCourseByIdWithUsersDetailService;


    public CourseController(GetAllCoursesService getAllCoursesService,
                            GetCourseByIdService getCourseByIdService,
                            CreateCourseService  createCourseService,
                            DeleteCourseService  deleteCourseService,
                            GetCourseByIdWithUsersDetailService getCourseByIdWithUsersDetailService)
    {

        this.getAllCoursesService = getAllCoursesService;
        this.getCourseByIdService = getCourseByIdService;
        this.createCourseService = createCourseService;
        this.deleteCourseService = deleteCourseService;
        this.getCourseByIdWithUsersDetailService = getCourseByIdWithUsersDetailService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses(){
        return getAllCoursesService.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id){
        return getCourseByIdWithUsersDetailService.execute(id);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody Course course){
        return createCourseService.execute(course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
        return deleteCourseService.execute(id);
    }

}
