package com.example.Student.service;

import com.example.Student.repository.StudentRepository;
import com.example.Student.model.Student;
import com.example.Student.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id: " + id));
    }

    public Student updateStudent(Integer id, Student updatedStudent) {
        Student student = getStudentById(id);

        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        student.setCourse(updatedStudent.getCourse());
        student.setMarks(updatedStudent.getMarks());

        return repository.save(student);
    }

    public void deleteStudent(Integer id) {
        Student student = getStudentById(id);
        repository.delete(student);
    }
}