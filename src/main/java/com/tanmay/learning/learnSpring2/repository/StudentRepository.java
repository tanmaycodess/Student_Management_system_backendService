package com.tanmay.learning.learnSpring2.repository;

import com.tanmay.learning.learnSpring2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
