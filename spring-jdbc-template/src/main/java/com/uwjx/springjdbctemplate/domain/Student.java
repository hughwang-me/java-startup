package com.uwjx.springjdbctemplate.domain;

import lombok.Data;

@Data
public class Student {

    private Long id;
    private String name;
    private Integer age;
    private Double height;
    private Double weight;
}
