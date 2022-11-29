package com.ironhack.w4d2.service.impl;

import com.ironhack.w4d2.model.Course;
import com.ironhack.w4d2.repository.CourseRepository;
import com.ironhack.w4d2.service.interfaces.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourseService {

    @Autowired
    CourseRepository courseRepository;

    public Course getCourseById(String course) {
        Optional<Course> courseOptional = courseRepository.findById(course);
        if (courseOptional.isEmpty()) return null;
        return courseOptional.get();
    }

    public List<Course> getCourseByClassroom(String classroom, Optional<Integer> hours) {
        if (hours.isPresent()) return courseRepository.findAllByClassroomAndHours(classroom, hours.get());
        return courseRepository.findAllByClassroom(classroom);
    }

    public void updateCourse(Course course, String id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty()) return;
        course.setCourse(id);
        courseRepository.save(course);
    }

    public void updateCourseHours(Integer hours, String id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty()) return;
        Course course = courseOptional.get();
        course.setHours(hours);
        courseRepository.save(course);
    }

    public void updateCourseClassroom(String classroom, String id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty()) return;
        Course course = courseOptional.get();
        course.setClassroom(classroom);
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty()) return;
        courseRepository.deleteById(id);
    }
}