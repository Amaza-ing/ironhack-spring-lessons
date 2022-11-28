package com.ironhack.w4d1.repository;

import com.ironhack.w4d1.model.Course;
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
        Course algebra = new Course("Algebra", 130, "B1", "2 weeks", null);
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
        for (Course course: courseList) {
            System.out.println(course);
        }
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


//    Este test se soluciona escribiendo @Transactional encima del @Repository de CourseRepository
//    Esto no es recomendable hacerlo, se considera una práctica peligrosa, para borrar elementos
//    es mejor utilizar siempre el deleteById
//    @Test
//    void deleteByClassroom() {
//        Course course = new Course("new course", 130, "F1", "2 weeks", 2);
//        courseRepository.save(course);
//        List<Course> courseList = courseRepository.findAll();
//        System.out.println("List with saved course: " + courseList);
//        courseRepository.deleteByClassroom("F1");
//        List<Course> courseListDeleted = courseRepository.findAll();
//        System.out.println("Original List: " + courseListDeleted);
//        assertEquals(8, courseList.size());
//    }


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


    //    ******************************************************************************
    //    ********************************* NATIVE SQL *********************************
    //    ******************************************************************************

    @Test
    void nativeFindAllWhereHours200_callMethod_courseList() {
        List<Course> courseList = courseRepository.nativeFindAllWhereHours200();
        System.out.println(courseList);
        assertEquals(1, courseList.size());
    }

    @Test
    void nativeFindHoursSum_callMethod_HoursSum() {
        Integer hoursSum = courseRepository.nativeFindHoursSum();
        System.out.println(hoursSum);
        assertEquals(940, hoursSum);
    }

    @Test
    void nativeFindAllWhereClassroomB1_callMethod_courseList() {
        List<Course> courseList = courseRepository.nativeFindAllWhereClassroomB1();
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    void nativeFindAllWhereContainingAlgebra_callMethod_courseList() {
        List<Course> courseList = courseRepository.nativeFindAllWhereContainingAlgebra();
        System.out.println(courseList);
        assertEquals(1, courseList.size());
    }

    @Test
    void nativeFindAllWhereHoursLessThan200_callMethod_courseList() {
        List<Course> courseList = courseRepository.nativeFindAllWhereHoursLessThan200();
        System.out.println(courseList);
        assertEquals(6, courseList.size());
    }

    @Test
    void nativeFindAllWhereClassroomAndHoursParams_validParams_correctCourses() {
        List<Course> courseList = courseRepository.nativeFindAllWhereClassroomAndHoursParams("B1", 160);
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    void nativeFindAllWhereClassroomAndHoursNamedParams_validParams_correctCourses() {
        List<Course> courseList = courseRepository.nativeFindAllWhereClassroomAndHoursNamedParams("B1", 160);
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    void nativeFindAllWhereContainingStrParam_validParam_correctCourses() {
        List<Course> courseList = courseRepository.nativeFindAllWhereContainingStrParam("Algebra");
        System.out.println(courseList);
        assertEquals(1, courseList.size());
    }
}