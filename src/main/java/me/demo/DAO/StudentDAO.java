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

    @XmlElement(name = "id")
    @Id
    private Integer id;

    public StudentDAO() {
    }
    public StudentDAO(String name, int id) {
        this.name = name;
        this.id = id;
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

