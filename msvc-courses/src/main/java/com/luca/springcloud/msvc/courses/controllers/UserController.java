package com.luca.springcloud.msvc.courses.controllers;


import com.luca.springcloud.msvc.courses.services.CourseServices.CreateCourseService;
import com.luca.springcloud.msvc.courses.services.CourseServices.DeleteCourseService;
import com.luca.springcloud.msvc.courses.services.CourseServices.GetAllCoursesService;
import com.luca.springcloud.msvc.courses.services.CourseServices.GetCourseByIdService;
import com.luca.springcloud.msvc.courses.models.Course;
import com.luca.springcloud.msvc.courses.models.CourseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class UserController {

    private final GetAllCoursesService getAllCoursesService;
    private final GetCourseByIdService getCourseByIdService;
    private final CreateCourseService createCourseService;
    private final DeleteCourseService deleteCourseService;

    public UserController(GetAllCoursesService getAllCoursesService,
        GetCourseByIdService getCourseByIdService,
        CreateCourseService  createCourseService,
        DeleteCourseService  deleteCourseService)
    {

        this.getAllCoursesService = getAllCoursesService;
        this.getCourseByIdService = getCourseByIdService;
        this.createCourseService = createCourseService;
        this.deleteCourseService = deleteCourseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses(){
        return getAllCoursesService.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id){
        return getCourseByIdService.execute(id);
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
