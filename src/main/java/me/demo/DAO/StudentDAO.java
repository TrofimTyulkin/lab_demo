package me.demo.DAO;

import jakarta.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "students")
public class StudentDAO {

    @XmlElement(name = "name")
    @Column(name = "name")
    private String name;

    @XmlElement(name = "name")
    @Column(name = "surname")
    private String surname;

    @XmlElement(name = "name")
    @Column(name = "fath_name")
    private String fath_name;

    @XmlElement(name = "name")
    @Column(name = "city")
    private String city;

    @XmlElement(name = "name")
    @Column(name = "country")
    private String country;

    @XmlElement(name = "name")
    @Column(name = "spec")
    private String spec;

    @XmlElement(name = "name")
    @Column(name = "age")
    private int age;

    @XmlElement(name = "id")
    @Id
    private Integer id;

    public StudentDAO(int age, String name, String surname, String fath_name, String city, String country, String spec, Integer id) {
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.fath_name = fath_name;
        this.city = city;
        this.country = country;
        this.spec = spec;
        this.id = id;
    }

    public StudentDAO(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFath_name() {
        return fath_name;
    }

    public void setFath_name(String fath_name) {
        this.fath_name = fath_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StudentDAO() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
}

