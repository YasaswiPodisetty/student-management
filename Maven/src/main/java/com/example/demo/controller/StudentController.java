package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student s) {
        return service.save(s);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return service.getAll();
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student s) {
        return service.update(id, s);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.delete(id);
        return "Deleted successfully";
    }
}