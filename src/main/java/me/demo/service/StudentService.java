package me.demo.service;

import me.demo.DAO.StudentDAO;
import me.demo.DAO.StudentList;

import java.util.List;

public interface StudentService {
    public StudentDAO getStudent(int id);
    public List<StudentDAO> getStudents();
    public void addStudents(StudentDAO studentDAO);
    public void deleteStudent(int id);
    public StudentDAO editStudent(int id, String name);
}
