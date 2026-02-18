package com.example.Student.model;

public class Student {

    private Integer id;
    private String name;
    private String email;
    private String course;
    private Integer marks;

    public Student() {
    }

    public Student(Integer id, String name, String email, String course, Integer marks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public Integer getMarks() { return marks; }
    public void setMarks(Integer marks) { this.marks = marks; }
}
