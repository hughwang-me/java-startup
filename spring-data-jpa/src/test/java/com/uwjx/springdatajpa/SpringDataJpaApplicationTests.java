package com.uwjx.springdatajpa;

import com.alibaba.fastjson.JSON;
import com.uwjx.springdatajpa.dao.ClassroomRepository;
import com.uwjx.springdatajpa.entity.Classroom;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Random;

@SpringBootTest
@Slf4j
class SpringDataJpaApplicationTests {

    @Autowired
    ClassroomRepository classroomRepository;


    @Test
    void save() {
        for (int i = 0; i < 20; i++) {
            Classroom classroom = new Classroom();
            classroom.setTeacher("王欢");
            classroom.setName("班级:" + i);
            classroom.setRoom("room - " + i);
            classroom.setScore(new Random().nextDouble());
            classroom.setLevel(new Random().nextInt());
            classroomRepository.save(classroom);
        }

        List<Classroom> classrooms = classroomRepository.findAll();
        for (Classroom classroomItem : classrooms) {
            log.warn("列表:{}", classroomItem.toString());
        }
    }


    @Test
    void findClassroomByName() {
        Classroom classroom = classroomRepository.findClassroomByNameLike("%三%");
        log.warn("查询结果:{}", JSON.toJSONString(classroom));
    }

    @Test
    void findList() {
        List<Classroom> classrooms = classroomRepository.findList("三");
        log.warn("查询结果:{}", JSON.toJSONString(classrooms));
    }

    @Test
    void pageable() {
        Pageable pageable = PageRequest.of(0, 3);
        Page<Classroom> classrooms = classroomRepository.findAll(pageable);
        log.warn("查询结果:{}", JSON.toJSONString(classrooms));
    }

    @Test
    void sort() {

        Pageable pageable = PageRequest.of(0, 3);
        List<Classroom> classrooms = classroomRepository.findAllByNameNotNullOrderByScoreDescLevelDesc();
        log.warn("查询结果:{}", JSON.toJSONString(classrooms));
    }

    @Test
    void pageableAndSort() {
        Sort sort = Sort.by(Sort.Direction.DESC , "level").and(Sort.by(Sort.Direction.DESC , "score"));
        Pageable pageable = PageRequest.of(0, 3 , sort);
        Page<Classroom> classrooms = classroomRepository.findAll(pageable);
        log.warn("查询结果:{}", JSON.toJSONString(classrooms));
    }
}
