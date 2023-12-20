package com.uwjx.springjdbctemplate;

import com.uwjx.springjdbctemplate.domain.Student;
import com.uwjx.springjdbctemplate.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class SpringJdbcTemplateApplicationTests {

	@Autowired
	StudentService studentService;

	@BeforeAll
	public static void before(){
		log.warn("前置操作");
	}

	@Test
	void add() {
		log.warn("开始测试");
		Student student = new Student();
		student.setAge(33);
		student.setName("王欢");
		student.setHeight(175.5d);
		student.setWeight(77.0);
		studentService.add(student);



	}

	@Test
	void count() {
		log.warn("开始测试统计");
		 log.warn("统计总数:{}" , studentService.count());
	}

	@Test
	void del() {
		log.warn("del");
		Student student = new Student();
		studentService.del(student);
	}

	@Test
	void query() {
		log.warn("query");
		Student student = new Student();
		List<Student> students = studentService.find(student);
		for (Student student1 : students) {
			log.warn("条目:{}" , student1.toString());
		}
	}
}
