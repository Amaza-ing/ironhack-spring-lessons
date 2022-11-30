package com.ironhack.w4d3.controller.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class CourseHoursDTO {
    @Max(value = 400, message = "The course cannot last longer than 400 hours")
    @Min(50)
    private Integer hours;

    public CourseHoursDTO() {
    }

    public CourseHoursDTO(Integer hours) {
        this.hours = hours;
    }

    public Integer getHours() {
        return hours;
    }
}
