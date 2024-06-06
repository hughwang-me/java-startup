package com.uwjx.springmvc.dal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "sync_data", schema = "wanghuan")
public class SyncData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sync_data_id_gen")
    @SequenceGenerator(name = "sync_data_id_gen", sequenceName = "sync_data_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "create_time")
    private Instant createTime;

    @Column(name = "update_time")
    private Instant updateTime;

}