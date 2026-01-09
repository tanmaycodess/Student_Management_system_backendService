package com.tanmay.learning.learnSpring2.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data // creates all getter and setter

public class AddStudentReqDto {
    @NotBlank(message = "name is required")
    @Size(min = 3 , max = 30 , message = "name shall lie between range 3 to 30 chars")
    private String name;

    @Email
    @NotBlank(message = "Email is required")
    private String email;

}


