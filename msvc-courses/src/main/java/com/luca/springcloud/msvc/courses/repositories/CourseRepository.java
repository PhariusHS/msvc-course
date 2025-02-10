package com.luca.springcloud.msvc.courses.repositories;

import com.luca.springcloud.msvc.courses.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
