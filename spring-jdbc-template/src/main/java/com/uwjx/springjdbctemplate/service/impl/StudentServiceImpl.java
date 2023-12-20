package com.uwjx.springjdbctemplate.service.impl;

import com.uwjx.springjdbctemplate.domain.Student;
import com.uwjx.springjdbctemplate.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private JdbcTemplate jdbcTemplate;

    public StudentServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Student add(Student student) {
        String sql = "insert into student (name , age, height , weight) values (?,?,?,?)";
        int result = jdbcTemplate.update(sql , student.getName() , student.getAge() , student.getHeight() , student.getWeight());
        log.warn("插入结果:{}" , result);
        return null;
    }

    @Override
    public int del(Student student) {
        return jdbcTemplate.update("delete from student");
    }

    @Override
    public Student modify(Student student) {
        return null;
    }

    @Override
    public List<Student> find(Student student) {
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
        List<Student> students = jdbcTemplate.query("select * from student" ,rowMapper);
        return students;
    }

    @Override
    public Student findOne(Student student) {
        return null;
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(id) from student" ,Integer.class);
    }
}
