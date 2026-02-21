package com.example.Student.repository;


import com.example.Student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Student.model.Student;

public interface StudentRepository extends JpaRepository<Student ,Integer> {
}