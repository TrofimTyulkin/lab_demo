package me.demo.service;

import lombok.RequiredArgsConstructor;
import me.demo.DAO.StudentDAO;
import me.demo.DTO.StudentFull;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class StudentServiceDB implements StudentService {
    //@Autowired
    private final StudentServiceRepository repository;

//    public StudentServiceDB(StudentServiceRepository repository){
//        this.repository = repository;
//    }

    @Override
    public StudentDAO getStudent(int id) {
        return repository.findById(id).orElse(new StudentDAO());
    }

    @Override
    public List<StudentDAO> getStudents() {
        return repository.findAll();
    }

    @Override
    public void addStudents(StudentDAO studentDAO) {
        repository.save(studentDAO);
    }

    @Override
    public void deleteStudent(int id) {
        repository.deleteById(id);
    }

    @Override
    public StudentDAO editStudent(StudentFull student) {
        StudentDAO studentDAO = getStudent(student.id());
        deleteStudent(student.id());
        studentDAO.setName(student.name());
        studentDAO.setSurname(student.surname());
        studentDAO.setFath_name(student.fath_name());
        studentDAO.setSpec(student.spec());
        studentDAO.setCity(student.city());
        studentDAO.setCountry(student.country());
        studentDAO.setAge(student.age());
        studentDAO.setId(student.id());
        System.err.println(studentDAO.toString());
        return repository.save(studentDAO);
    }
}
