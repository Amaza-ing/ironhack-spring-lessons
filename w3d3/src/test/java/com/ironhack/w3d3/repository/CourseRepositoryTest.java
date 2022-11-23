package com.ironhack.w3d3.repository;

import com.ironhack.w3d3.model.Course;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @BeforeEach
    public void setUp() {
        Course algebra = new Course("Algebra", 130, "B1", "2 weeks", 2);
        courseRepository.save(algebra);
    }

    @AfterEach
    public void tearDown() {
        courseRepository.deleteById("Algebra");
    }


    //    ******************************************************************************
    //    ************************************* JPA ************************************
    //    ******************************************************************************

    @Test
    public void findAll_courses_courseList() {
        List<Course> courseList = courseRepository.findAll();
        System.out.println(courseList);
        assertEquals(7, courseList.size());
    }

    @Test
    public void findById_validId_correctCourse() {
        Optional<Course> course = courseRepository.findById("Math");
        assertTrue(course.isPresent());
        System.out.println(course.get());
        assertEquals(100, course.get().getHours());
    }

    @Test
    public void findById_invalidId_courseNotPresent() {
        Optional<Course> course = courseRepository.findById("Politics");
        assertFalse(course.isPresent());
    }

    @Test
    public void findByHours_validHours_correctCourse() {
        Optional<Course> course = courseRepository.findByHours(90);
        assertTrue(course.isPresent());
        System.out.println(course.get());
        assertEquals("English", course.get().getCourse());
    }

    @Test
    void findAllByClassroom_validClassroom_courseList() {
        List<Course> courseList = courseRepository.findAllByClassroom("B1");
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    void findAllByCourseContaining_presentString_courseList() {
        List<Course> courseList = courseRepository.findAllByCourseContaining("p");
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    void findAllByHoursLessThan_validHours_courseList() {
        List<Course> courseList = courseRepository.findAllByHoursLessThan(150);
        System.out.println(courseList);
        assertEquals(4, courseList.size());
    }


//    ******************************************************************************
//    ************************************ JPQL ************************************
//    ******************************************************************************

    @Test
    void findAllWhereHours200_callMethod_courseList() {
        List<Course> courseList = courseRepository.findAllWhereHours200();
        System.out.println(courseList);
        assertEquals(1, courseList.size());
    }

    @Test
    void findHoursSum_callMethod_HoursSum() {
        Integer hoursSum = courseRepository.findHoursSum();
        System.out.println(hoursSum);
        assertEquals(940, hoursSum);
    }

    @Test
    void findAllWhereClassroomB1_callMethod_courseList() {
        List<Course> courseList = courseRepository.findAllWhereClassroomB1();
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    void findAllWhereContainingAlgebra_callMethod_courseList() {
        List<Course> courseList = courseRepository.findAllWhereContainingAlgebra();
        System.out.println(courseList);
        assertEquals(1, courseList.size());
    }

    @Test
    void findAllWhereHoursLessThan200_callMethod_courseList() {
        List<Course> courseList = courseRepository.findAllWhereHoursLessThan200();
        System.out.println(courseList);
        assertEquals(6, courseList.size());
    }

    @Test
    void findAllWhereClassroomAndHoursParams_validParams_correctCourses() {
        List<Course> courseList = courseRepository.findAllWhereClassroomAndHoursParams("B1", 160);
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    void findAllWhereClassroomAndHoursNamedParams_validParams_correctCourses() {
        List<Course> courseList = courseRepository.findAllWhereClassroomAndHoursNamedParams("B1", 160);
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    void findAllWhereContainingStrParam_validParam_correctCourses() {
        List<Course> courseList = courseRepository.findAllWhereContainingStrParam("Algebra");
        System.out.println(courseList);
        assertEquals(1, courseList.size());
    }
}