package com.ironhack.w3d5.model;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String houseCode;

//    Esto es para convertir la relación uno a uno en bidireccional, no es necesario para hacer el join
//    Si lo ponemos, hay que tener cuidado para que no ocurra un error de tipo stack overflow
//    @OneToOne(mappedBy = "address")
//    private Teacher teacher;

    public Address() {
    }

    public Address(String street, String houseCode) {
        this.street = street;
        this.houseCode = houseCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", houseCode='" + houseCode + '\'' +
                '}';
    }
}
