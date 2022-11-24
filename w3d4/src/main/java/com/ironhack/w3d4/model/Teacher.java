package com.ironhack.w3d4.model;

import javax.persistence.*;

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





//  Necesitamos el constructor vacío
    public Teacher() {
    }

    //  Necesitamos el constructor con todos los elementos (no hacen falta los elemntos autogenerados)

    public Teacher(Integer id, String teacher, Address address) {
        this.id = id;
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
