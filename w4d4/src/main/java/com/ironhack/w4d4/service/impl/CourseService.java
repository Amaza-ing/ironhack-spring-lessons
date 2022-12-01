package com.ironhack.w4d4.service.impl;

import com.ironhack.w4d4.model.Course;
import com.ironhack.w4d4.repository.CourseRepository;
import com.ironhack.w4d4.service.interfaces.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourseService {

    @Autowired
    CourseRepository courseRepository;

    public Course getCourseById(String course) {
        Optional<Course> courseOptional = courseRepository.findById(course);
        if (courseOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        return courseOptional.get();
    }

    public List<Course> getCourseByClassroom(String classroom, Optional<Integer> hours) {
        if (hours.isPresent()) return courseRepository.findAllByClassroomAndHours(classroom, hours.get());
        return courseRepository.findAllByClassroom(classroom);
    }

    public void save(Course course) {
        Optional<Course> courseOptional = courseRepository.findById(course.getCourse());
        if (courseOptional.isPresent())
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "The course already exists");
        courseRepository.save(course);
    }

    public void updateCourse(Course course, String id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        course.setCourse(id);
        courseRepository.save(course);
    }

    public void updateCourseHours(Integer hours, String id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        Course course = courseOptional.get();
        course.setHours(hours);
        courseRepository.save(course);
    }

    public void updateCourseClassroom(String classroom, String id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        Course course = courseOptional.get();
        course.setClassroom(classroom);
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        courseRepository.deleteById(id);
    }
}
