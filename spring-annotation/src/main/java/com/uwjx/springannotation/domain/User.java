package com.uwjx.springannotation.domain;

import com.uwjx.springannotation.annotation.AgeValidated;
import lombok.Data;

@Data
public class User {

    @AgeValidated(maxAge = 60, minAge = 8, defAge = 18)
    private int age;

    private String name;

}
