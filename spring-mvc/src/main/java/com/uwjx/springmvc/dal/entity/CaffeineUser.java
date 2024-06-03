package com.uwjx.springmvc.dal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "caffeine_user", schema = "wanghuan")
public class CaffeineUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caffeine_user_id_gen")
    @SequenceGenerator(name = "caffeine_user_id_gen", sequenceName = "caffeine_user_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private BigDecimal age;

    @Column(name = "mark", length = Integer.MAX_VALUE)
    private String mark;

}