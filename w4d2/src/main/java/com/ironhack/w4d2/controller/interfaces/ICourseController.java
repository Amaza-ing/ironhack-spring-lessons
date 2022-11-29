package com.ironhack.w4d2.controller.interfaces;

import com.ironhack.w4d2.model.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseController {

//  ******************************************************  GET  ******************************************************

    List<Course> getAllCourses();
    Course getCourseById(String course);
    List<Course> getCourseByHoursLessThan(Integer hours);
    List<Course> getCourseByClassroom(String classroom, Optional<Integer> hours);


//  *****************************************************  POST  ******************************************************

    void saveCourse(Course course);

}
