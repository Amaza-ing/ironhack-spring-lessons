package com.ironhack.w4d2.controller.dto;

import javax.validation.constraints.NotEmpty;

public class CourseClassroomDTO {
    @NotEmpty(message = "Classroom cannot be empty")
    private String classroom;

    public String getClassroom() {
        return classroom;
    }
}
