package me.demo.service;

import me.demo.DAO.StudentDAO;

import java.util.List;

public interface StudentService{
    StudentDAO getStudent(int id);
    List<StudentDAO> getStudents();
    void addStudents(StudentDAO studentDAO);
    void deleteStudent(int id);
    StudentDAO editStudent(int id, String name);
}
