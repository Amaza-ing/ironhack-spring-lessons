package com.ironhack.w4d4.service.interfaces;

import com.ironhack.w4d4.model.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    Course getCourseById(String course);
    List<Course> getCourseByClassroom(String classroom, Optional<Integer> hours);

    void save(Course course);

    void updateCourse(Course course, String id);

    void updateCourseHours(Integer hours, String id);
    void updateCourseClassroom(String classroom, String id);

    void deleteCourse(String id);

}
