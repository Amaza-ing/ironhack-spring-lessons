package com.ironhack.w4d4.controller.interfaces;

import com.ironhack.w4d4.controller.dto.CourseClassroomDTO;
import com.ironhack.w4d4.controller.dto.CourseHoursDTO;
import com.ironhack.w4d4.model.Course;

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


//  ******************************************************  PUT  ******************************************************

    void updateCourse(Course course, String id);


//  *****************************************************  PATCH  *****************************************************

    void updateCourseHours(CourseHoursDTO courseHoursDTO, String id);
    void updateCourseClassroom(CourseClassroomDTO courseClassroomDTO, String id);


//  ****************************************************  DELETE  *****************************************************

    void deleteCourse(String id);

}
