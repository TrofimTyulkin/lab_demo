package me.demo.service;

import lombok.RequiredArgsConstructor;
import me.demo.DAO.StudentDAO;
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
    public StudentDAO editStudent(int id, String name) {
        StudentDAO student = getStudent(id);
        deleteStudent(id);
        student.setName(name);
        return repository.save(student);
    }
}
