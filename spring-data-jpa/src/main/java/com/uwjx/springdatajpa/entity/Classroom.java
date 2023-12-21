package com.uwjx.springdatajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Classroom {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String teacher;

    private String room;

    private Double score;

    private Integer level;
}
