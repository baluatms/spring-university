package com.springboot.university.controller;

import com.springboot.university.exception.StudentNotFoundException;
import com.springboot.university.entity.Student;
import com.springboot.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/university")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/register")
    public Student registerStudent(@RequestBody Student student) {

        return studentService.registerStudent(student);
    }

    @GetMapping(value = "/students")
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }

    @GetMapping(value = "/student/{id}")
    public Student getStudentById(@PathVariable int id) throws StudentNotFoundException {

        return studentService.getStudentById(id);
    }

    @GetMapping(value = "/students/filterByBranch")
    public List<Student> getAllStudentsInBranch(@RequestParam("branch_name") String branch_name) {
        return studentService.getAllStudentInBranch(branch_name);
    }
}
