package com.dredh.entity;

import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Value
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer age;

    private String name;
}
