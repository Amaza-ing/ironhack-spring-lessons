package com.ironhack.w4d3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "teacher")
    private String teacher;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "teacher")
    @ToString.Exclude
    @JsonIgnore
    private Set<Course> courses;

//    relación unidireccional one to many
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "teacher_id")
//    private Set<Course> courses;
}
