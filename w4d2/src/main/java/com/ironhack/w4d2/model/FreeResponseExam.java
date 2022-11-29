package com.ironhack.w4d2.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "course")
public class FreeResponseExam extends Exam{
    public FreeResponseExam() {
    }

    public FreeResponseExam(String course, Date startDate, Boolean mandatory) {
        super(course, startDate, mandatory);
    }

}
