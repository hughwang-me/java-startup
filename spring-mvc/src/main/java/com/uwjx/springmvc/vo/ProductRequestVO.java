package com.uwjx.springmvc.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ProductRequestVO {

    private Long id;
    private String name;
    private Double age;
    private Date time;
}
