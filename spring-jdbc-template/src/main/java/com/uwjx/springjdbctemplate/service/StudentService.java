package com.uwjx.springjdbctemplate.service;

import com.uwjx.springjdbctemplate.domain.Student;

import java.util.List;

public interface StudentService {

    Student add(Student student);

    int del(Student student);

    Student modify(Student student);

    List<Student> find(Student student);

    Student findOne(Student student);

    int count();

}
