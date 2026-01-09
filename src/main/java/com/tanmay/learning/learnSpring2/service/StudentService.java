package com.tanmay.learning.learnSpring2.service;

import com.tanmay.learning.learnSpring2.dto.AddStudentReqDto;
import com.tanmay.learning.learnSpring2.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentReqDto addStudentDto);

    void deleteStudentById(Long id);
}
