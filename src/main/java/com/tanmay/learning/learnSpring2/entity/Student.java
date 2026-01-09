package com.tanmay.learning.learnSpring2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {

    @Id // to show the type
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is to auto generate the ids , there are different types of strategy available
    private long id; // data field

    private String name;

    private String email;
}
