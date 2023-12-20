package com.uwjx.springjdbctemplate.controller;

import com.uwjx.springjdbctemplate.domain.Student;
import com.uwjx.springjdbctemplate.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "test")
    public List<Student> test(){
        Student student = new Student();
        return studentService.find(student);
    }
}
