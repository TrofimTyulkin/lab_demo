package me.demo.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.demo.DAO.StudentDAO;
import me.demo.DTO.Student;
import me.demo.DTO.StudentFull;
import me.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RequestMapping(value = "/student")

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {

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
    StudentFull getStudent(@PathVariable int id){
        StudentDAO response = service.getStudent(id);
        return new StudentFull(response.getName(), response.getSurname(), response.getFath_name(),response.getCity(),
        response.getCountry(),response.getSpec(), response.getAge(), response.getId());
    }

    @Operation(summary = "Изменить студента по id")
    @PutMapping("/{id}")
    StudentFull editStudent(@PathVariable int id, @RequestBody StudentFull request){
        StudentDAO response = service.editStudent(request);
        return new StudentFull(response.getName(), response.getSurname(), response.getFath_name(), response.getCity(),
                response.getCountry(), response.getSpec(), request.age(), response.getId());
    }

    @Operation(summary = "Добавить студента")
    @PostMapping
    String addStudent(@RequestBody @Valid StudentFull request) throws URISyntaxException {
        service.addStudents(new StudentDAO(request.age(), request.name(), request.surname(), request.fath_name(),
                request.city(), request.country(), request.spec(), request.id()));
        return  "student add";
    }

    @Operation(summary = "Убрать студента")
    @DeleteMapping("/{id}")
    String deleteLink(@PathVariable int id){
        service.deleteStudent(id);
        return  "delete successful " + id;
    }

}

