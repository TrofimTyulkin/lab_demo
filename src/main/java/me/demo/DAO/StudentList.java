package me.demo.DAO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentList {
    @XmlElement(name = "student")
    List<StudentDAO> student;

    public List<StudentDAO> getStudents() {
        return student;
    }

    public void setStudents(List<StudentDAO> students) {
        this.student = students;

    }

}
