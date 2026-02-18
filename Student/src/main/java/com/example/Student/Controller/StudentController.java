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

    // ✅ Add Student
    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Student student) {

        // Validation
        if (student.getName() == null || student.getName().trim().isEmpty()) {
            return new ResponseEntity<>("Name cannot be empty", HttpStatus.BAD_REQUEST);
        }

        if (student.getEmail() == null || !student.getEmail().contains("@")) {
            return new ResponseEntity<>("Invalid email format", HttpStatus.BAD_REQUEST);
        }

        if (student.getMarks() == null || student.getMarks() < 0 || student.getMarks() > 100) {
            return new ResponseEntity<>("Marks must be between 0 and 100", HttpStatus.BAD_REQUEST);
        }

        studentList.add(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // ✅ Get All Students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    // ✅ Get Student By ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer id) {

        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return new ResponseEntity<>(student, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Student not found with ID: " + id,
                HttpStatus.NOT_FOUND);
    }

    // ✅ Update Student
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id,
                                           @RequestBody Student updatedStudent) {

        for (Student student : studentList) {
            if (student.getId().equals(id)) {

                // Validation again
                if (updatedStudent.getName() == null || updatedStudent.getName().trim().isEmpty()) {
                    return new ResponseEntity<>("Name cannot be empty", HttpStatus.BAD_REQUEST);
                }

                if (updatedStudent.getEmail() == null || !updatedStudent.getEmail().contains("@")) {
                    return new ResponseEntity<>("Invalid email format", HttpStatus.BAD_REQUEST);
                }

                if (updatedStudent.getMarks() == null || updatedStudent.getMarks() < 0 || updatedStudent.getMarks() > 100) {
                    return new ResponseEntity<>("Marks must be between 0 and 100", HttpStatus.BAD_REQUEST);
                }

                student.setName(updatedStudent.getName());
                student.setEmail(updatedStudent.getEmail());
                student.setCourse(updatedStudent.getCourse());
                student.setMarks(updatedStudent.getMarks());

                return new ResponseEntity<>(student, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Student not found with ID: " + id,
                HttpStatus.NOT_FOUND);
    }

    // ✅ Delete Student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {

        Student studentToRemove = null;

        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            studentList.remove(studentToRemove);
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("Student not found with ID: " + id,
                HttpStatus.NOT_FOUND);
    }
}
