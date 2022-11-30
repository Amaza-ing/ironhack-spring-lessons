package com.ironhack.w4d3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Course {
    @Id
    private String course;

    @Max(value = 400, message = "The course cannot last longer than 400 hours")
    @Min(50)
    private Integer hours;

    @NotEmpty(message = "Classroom cannot be empty")
    private String classroom;
    private String vacations;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
