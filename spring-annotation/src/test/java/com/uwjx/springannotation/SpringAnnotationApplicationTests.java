package com.uwjx.springannotation;

import com.uwjx.springannotation.annotation.AgeValidated;
import com.uwjx.springannotation.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;

//@SpringBootTest
@Slf4j
class SpringAnnotationApplicationTests {

	@Test
	void contextLoads() {

		User user = new User();
		user.setAge(1);
		user.setName("王欢");

		log.warn("用户对象:{}" , user.toString());

		Field[] fields = user.getClass().getDeclaredFields();
		for (Field field : fields) {
			String fieldName = field.getName();
			log.warn("属性名称 : {}" , fieldName);
			if(field.isAnnotationPresent(AgeValidated.class)){
				log.warn("有注解");
				AgeValidated validated = field.getAnnotation(AgeValidated.class);
				try {
					// 获取字段值（需要设置访问权限）
					field.setAccessible(true);
					int age = (int) field.get(user);
					log.warn("属性值 : {}" , age);
					if(age > validated.maxAge() || age < validated.minAge()){
						log.warn("年龄不合法");
						user.setAge(validated.defAge());
					}
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			}else {
				log.warn("没有注解");
			}
		}
		log.warn("用户对象:{}" , user.toString());

	}

}
