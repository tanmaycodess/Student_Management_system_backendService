package com.tanmay.learning.learnSpring2.service.implementation;

import com.tanmay.learning.learnSpring2.dto.AddStudentReqDto;
import com.tanmay.learning.learnSpring2.dto.StudentDto;
import com.tanmay.learning.learnSpring2.entity.Student;
import com.tanmay.learning.learnSpring2.repository.StudentRepository;
import com.tanmay.learning.learnSpring2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class StudentServiceImplementation implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    // we have @RequiredArgsConstructor so no need of this constructor , it does that automatically
//    public StudentServiceImplementation(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        return students
                .stream()
                .map(s -> new StudentDto(s.getId(), s.getName(), s.getEmail()))
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student =
                studentRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student of this id not found"));

        return modelMapper.map(student , StudentDto.class);
    }

    @Override
    public  StudentDto createNewStudent(AddStudentReqDto addStudentDto) {
        // we first have to create a student class object ,
        // because we need to save it in that class ,
        // so we convert AddStudentReqDto class object into a new student class object
        Student newStudent = modelMapper.map(addStudentDto, Student.class);

        // we pass new student object into save
        Student student = studentRepository.save(newStudent);

        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("student does not exists by id" + id);
        }
        studentRepository.deleteById(id);
    }
}

