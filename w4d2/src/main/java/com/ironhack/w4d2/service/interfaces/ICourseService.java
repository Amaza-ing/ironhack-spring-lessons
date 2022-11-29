package com.ironhack.w4d2.service.interfaces;

import com.ironhack.w4d2.model.Course;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    Course getCourseById(String course);
    List<Course> getCourseByClassroom(String classroom, Optional<Integer> hours);

}
