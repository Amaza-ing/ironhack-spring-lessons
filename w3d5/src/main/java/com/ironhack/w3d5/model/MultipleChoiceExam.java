package com.ironhack.w3d5.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "course")
public class MultipleChoiceExam extends Exam{
    private Integer numberOfChoices;

    public MultipleChoiceExam() {
    }

    public MultipleChoiceExam(String course, Date startDate, Boolean mandatory, Integer numberOfChoices) {
        super(course, startDate, mandatory);
        this.numberOfChoices = numberOfChoices;
    }

    public Integer getNumberOfChoices() {
        return numberOfChoices;
    }

    public void setNumberOfChoices(Integer numberOfChoices) {
        this.numberOfChoices = numberOfChoices;
    }
}
