package com.ironhack.w4d2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    private String course;
    private Integer hours;
    private String classroom;
    private String vacations;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
