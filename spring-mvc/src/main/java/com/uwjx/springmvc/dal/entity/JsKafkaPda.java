package com.uwjx.springmvc.dal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "js_kafka_pda", schema = "wanghuan")
public class JsKafkaPda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "js_kafka_pda_id_gen")
    @SequenceGenerator(name = "js_kafka_pda_id_gen", sequenceName = "wanghuan.js_kafka_pda_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "id_num", length = Integer.MAX_VALUE)
    private String idNum;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "date")
    private Instant date;

}