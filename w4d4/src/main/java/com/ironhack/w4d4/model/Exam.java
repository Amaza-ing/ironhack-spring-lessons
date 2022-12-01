package com.ironhack.w4d4.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Exam {
    @Id
    private String course;
    private Date startDate;
    private Boolean mandatory;

    public Exam() {
    }

    public Exam(String course, Date startDate, Boolean mandatory) {
        this.course = course;
        this.startDate = startDate;
        this.mandatory = mandatory;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Boolean getMandatory() {
        return mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }
}
