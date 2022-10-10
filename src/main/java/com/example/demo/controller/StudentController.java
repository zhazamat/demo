package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    List<Student> studentList=new ArrayList<>();
    public  void initStudents(){
        studentList.add(new Student(1,"AA",24));
        studentList.add(new Student(2,"Janar",24));
        studentList.add(new Student(3,"BB",22));
        studentList.add(new Student(4,"CC",24));
        studentList.add(new Student(5,"DD",21));
    }
    @GetMapping("/list")
    public List<Student> getStudents(){
        initStudents();
        return studentList;
    }
}
