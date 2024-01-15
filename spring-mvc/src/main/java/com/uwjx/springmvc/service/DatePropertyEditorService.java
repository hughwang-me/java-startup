package com.uwjx.springmvc.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
//@Service
public class DatePropertyEditorService {

    @Value("2020-10-10")
    private Date date;

    @PostConstruct
    public void run(){
        log.warn("date : {}" , date);
    }
}

