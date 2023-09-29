package me.demo.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.demo.DAO.StudentDAO;
import me.demo.DAO.StudentList;
import me.demo.DTO.Student;
import me.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RequestMapping(value = "/student")

@RestController
@Slf4j
@RequiredArgsConstructor
public class StundentController {

    private final StudentService service;


    @ApiResponse(responseCode = "200", description = "Обновление обработано")
    @ApiResponse(responseCode = "400", description = "Некорректные параметры запроса")
    @ApiResponse(responseCode = "404", description = "Ресурс не найден")

    @Operation(summary = "Получить всех студентов")
    @GetMapping
    List<StudentDAO> getAllStudents(){

        return service.getStudents();
    }

    @Operation(summary = "Получить студента по id")
    @GetMapping("/{id}")
    Student getStudent(@PathVariable int id){
        StudentDAO response = service.getStudent(id);
        return new Student(response.getName(), response.getId());
    }

    @Operation(summary = "Изменить студента по id")
    @PutMapping("/{id}")
    Student editStudent(@PathVariable int id, @RequestBody String name){
        StudentDAO response = service.editStudent(id,name);
        return new Student(response.getName(), response.getId());
    }

    @Operation(summary = "Добавить студента")
    @PostMapping
    String addStudent(@RequestBody @Valid Student request) throws URISyntaxException {

        service.addStudents(new StudentDAO(request.name(), request.id()));
        return  "student add";
    }

    @Operation(summary = "Убрать студента")
    @DeleteMapping("/{id}")
    String deleteLink(@PathVariable int id){
        service.deleteStudent(id);
        return  "delete successful " + id;
    }

}

