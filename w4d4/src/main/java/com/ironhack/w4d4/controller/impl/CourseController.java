package com.ironhack.w4d4.controller.impl;

import com.ironhack.w4d4.controller.dto.CourseClassroomDTO;
import com.ironhack.w4d4.controller.dto.CourseHoursDTO;
import com.ironhack.w4d4.controller.interfaces.ICourseController;
import com.ironhack.w4d4.model.Course;
import com.ironhack.w4d4.repository.CourseRepository;
import com.ironhack.w4d4.service.interfaces.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController implements ICourseController {

    @Autowired
    ICourseService courseService;

    @Autowired
    CourseRepository courseRepository;


    //  ******************************************************  GET  ******************************************************

    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/courses/{course}")
    public Course getCourseById(@PathVariable(name = "course") String course) {
        return courseService.getCourseById(course);
    }

    @GetMapping("/courses/hours")
    public List<Course> getCourseByHoursLessThan(@RequestParam(defaultValue = "100") Integer hours) {
        return courseRepository.findAllByHoursLessThan(hours);
    }

    @GetMapping("/courses/classroom")
    public List<Course> getCourseByClassroom(
            @RequestParam(defaultValue = "A1") String classroom,
            @RequestParam Optional<Integer> hours
    ) {
        return courseService.getCourseByClassroom(classroom, hours);
    }


    //  *****************************************************  POST  ******************************************************

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody @Valid Course course) {
        courseService.save(course);
    }


    //  ******************************************************  PUT  ******************************************************

    @PutMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCourse(@RequestBody @Valid Course course, @PathVariable String id) {
        courseService.updateCourse(course, id);
    }


    //  *****************************************************  PATCH  *****************************************************

    @PatchMapping("/courses/hours/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCourseHours(@RequestBody @Valid CourseHoursDTO courseHoursDTO, @PathVariable String id) {
        courseService.updateCourseHours(courseHoursDTO.getHours(), id);
    }

    @PatchMapping("/courses/classroom/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCourseClassroom(@RequestBody @Valid CourseClassroomDTO courseClassroomDTO, @PathVariable String id) {
        courseService.updateCourseClassroom(courseClassroomDTO.getClassroom(), id);
    }


    //  ****************************************************  DELETE  *****************************************************

    @DeleteMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }
}
