package com.tanmay.learning.learnSpring2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// data annotation automatically creates the commented boiler plate code
// creates all argument constructor like below
@Data // creates all getter and setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private long id;

    private String name;

    private String email;

}


