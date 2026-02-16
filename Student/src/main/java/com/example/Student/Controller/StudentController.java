package com.example.Student.Controller;


import com.example.Student.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> studentList = new ArrayList<>();

    // Add Student
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        studentList.add(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Get All Students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    // Get Student By ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {

        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return new ResponseEntity<>(student, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Student not found with ID: " + id,
                HttpStatus.NOT_FOUND);
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {

        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                studentList.remove(student);
                return new ResponseEntity<>("Student deleted successfully",
                        HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Student not found with ID: " + id,
                HttpStatus.NOT_FOUND);
    }
}