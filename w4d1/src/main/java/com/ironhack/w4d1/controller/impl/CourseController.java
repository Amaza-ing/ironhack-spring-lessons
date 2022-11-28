package com.ironhack.w4d1.controller.impl;

import com.ironhack.w4d1.controller.interfaces.ICourseController;
import com.ironhack.w4d1.model.Course;
import com.ironhack.w4d1.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api") // Anotación que nos condiciona como comienzan el resto de las rutas del controlador
public class CourseController implements ICourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/courses") // Esta anotación identifica el método GET HTTP
    @ResponseStatus(HttpStatus.OK) // Dictamina la respuesta HTTP que se producirá al consumir el endpoint
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // @PathVariable nos permite crear variables de ruta que vendrán entre {}, si el nombre de la variable de ruta coicide con
    // el nombre de la variable del parámetro del método no es necesario poner name = "variableName"
    @GetMapping("/courses/{course}")
    public Course getCourseById(@PathVariable(name = "course") String course) {
        Optional<Course> courseOptional = courseRepository.findById(course);
        if (courseOptional.isEmpty()) return null;
        return courseOptional.get();
    }

//    /courses/hours?hours=200
//    @RequestParam nos permite crear query params, y con defaultValue podremos acceder al endpoint correspondiente
//    sin necesidad de especificar el valor de este parámetro
    @GetMapping("/courses/hours")
    public List<Course> getCourseByHoursLessThan(@RequestParam(defaultValue = "100") Integer hours) {
        return courseRepository.findAllByHoursLessThan(hours);
    }

    @GetMapping("/courses/classroom")
    public List<Course> getCourseByClassroom(
            @RequestParam(defaultValue = "A1") String classroom,
            @RequestParam Optional<Integer> hours  // Definiendo el tipo de variable de un query param como optional nos permite no tener que especificarlo en la ruta
    ) {
        if (hours.isPresent()) return courseRepository.findAllByClassroomAndHours(classroom, hours.get());
        return courseRepository.findAllByClassroom(classroom);
    }
}
