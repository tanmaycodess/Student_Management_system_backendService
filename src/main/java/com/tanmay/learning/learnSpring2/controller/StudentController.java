package com.tanmay.learning.learnSpring2.controller;

import com.tanmay.learning.learnSpring2.dto.AddStudentReqDto;
import com.tanmay.learning.learnSpring2.dto.StudentDto;
import com.tanmay.learning.learnSpring2.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get-student")
    // we use response entity to send status codes with output
    public ResponseEntity<List<StudentDto>> getStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id)); // another way to send ok response
    }

    @PostMapping("/add-student")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentReqDto addStudentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);

        return ResponseEntity.noContent().build();
    }
}
