package me.demo.service;

import me.demo.DAO.StudentDAO;
import me.demo.DAO.StudentList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Service
public class StudentServiceCollection implements StudentService {
    List<StudentDAO> studentDAOS = new ArrayList<StudentDAO>();

    public List<StudentDAO> getStudents() {
        return studentDAOS;
    }

    public StudentDAO getStudent(int id) {
        final StudentDAO[] value = new StudentDAO[1];
        studentDAOS.forEach(studentDAO -> {
            if (studentDAO.getId() == id)
                value[0] = studentDAO;
        });
        return value[0];
    }

    public void addStudents(StudentDAO studentDAO) {
        studentDAOS.add(studentDAO);
    }

    @Override
    public void deleteStudent(int id) {
        studentDAOS = studentDAOS.stream().filter(studentDAO -> studentDAO.getId() != id)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDAO editStudent(int id, String name) {
        return studentDAOS.stream().filter(studentDAO -> studentDAO.getId() == id).findFirst()
                .map(studentDAO -> {
                    studentDAO.setName(name);
                    return studentDAO;
                }).orElse(new StudentDAO());
    }
}
