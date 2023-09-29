package me.demo.service;

import me.demo.DAO.StudentDAO;
import me.demo.DAO.StudentList;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceXML implements StudentService {
    @Override
    public StudentDAO getStudent(int id) {
        final StudentDAO[] value = new StudentDAO[1];

        getStudentsFromXml().getStudents().forEach(studentDAO -> {
            if (studentDAO.getId() == id)
                value[0] = studentDAO;
        });
        return value[0];
    }

    @Override
    public List<StudentDAO> getStudents() {
        return getStudentsFromXml().getStudents();
    }

    @Override
    public void addStudents(StudentDAO studentDAO) {
        List<StudentDAO> list = getStudentsFromXml().getStudents();
        list.add(studentDAO);
        list.forEach(foo -> System.err.println(foo.getId()));
        StudentList list1 = new StudentList();
        list1.setStudents(list);
        System.err.println("SAVING..........");
        try {
            save(list1);
            System.err.println("SAVEEEEEEEEEEEEEE");
        } catch (JAXBException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteStudent(int id) {
        List<StudentDAO> list = getStudentsFromXml().getStudents();
        list = list.stream().filter(student -> student.getId() != id)
                .collect(Collectors.toList());
        list.forEach(foo -> System.err.println(foo.getId()));
        StudentList list1 = new StudentList();
        list1.setStudents(list);
        System.err.println("SAVING..........");
        try {
            save(list1);
            System.err.println("SAVEEEEEEEEEEEEEE");
        } catch (JAXBException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public StudentDAO editStudent(int id, String name) {
        List<StudentDAO> list = getStudentsFromXml().getStudents();

        return list.stream().filter(studentDAO -> studentDAO.getId() == id).findFirst()
                .map(studentDAO -> {
                    studentDAO.setName(name);
                    StudentList list1 = new StudentList();
                    list1.setStudents(list);
                    System.err.println("SAVING..........");
                    try {
                        save(list1);
                        System.err.println("SAVEEEEEEEEEEEEEE");
                    } catch (JAXBException | URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                    return studentDAO;
                }).orElse(new StudentDAO());

    }
    public void save(StudentList list) throws JAXBException, URISyntaxException {
        JAXBContext context = JAXBContext.newInstance(StudentList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(list, new File(getClass().getResource("/students.xml").toURI()));
    }

    public StudentList getStudentsFromXml(){
        try {
            JAXBContext context = JAXBContext.newInstance(StudentList.class);
            return (StudentList) context.createUnmarshaller()
                    .unmarshal(new File(getClass().getResource("/students.xml").toURI()));
        } catch (JAXBException | URISyntaxException e) {
            System.err.println("error");
            throw new RuntimeException(e);
        }
    }
}
