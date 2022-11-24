package com.ironhack.w3d4.model;

import javax.persistence.*;
import java.util.Set;

@Entity // imprescindible en todas las entidades
@Table(name = "teacher") // necesario cuando el nombre de la tabla sea diferente al de la clase
public class Teacher {
    @Id // annotation para indicar primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // annotation para indicar auto_increment
    @Column(name = "id") // necesario si el campo de SQL tiene otro nombre
    private Integer id;

    @Column(name = "teacher")
    private String teacher;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

//    Esto es para convertir la relación many to one en bidireccional, no es necesario para hacer el join
//    Si lo ponemos, hay que tener cuidado para que no ocurra un error de tipo stack overflow
    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses;




//  Necesitamos el constructor vacío
    public Teacher() {
    }

    //  Necesitamos el constructor con todos los elementos (no hacen falta los elemntos autogenerados)
    public Teacher(String teacher, Address address) {
        this.teacher = teacher;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                ", address=" + address +
                '}';
    }
}
