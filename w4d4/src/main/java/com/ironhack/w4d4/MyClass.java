package com.ironhack.w4d4;

import com.ironhack.w4d4.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyClass {
    @Autowired
    CourseRepository courseRepository;

    public void findAll(){
        System.out.println(courseRepository.findAll());
    }
}
