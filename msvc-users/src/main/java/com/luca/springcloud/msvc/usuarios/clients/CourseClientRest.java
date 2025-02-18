package com.luca.springcloud.msvc.usuarios.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-courses", url = "localhost:8081/user")
public interface CourseClientRest {

    @DeleteMapping("/delete/{id}")
    Void deleteCourseUserById(@PathVariable Long id);

}
