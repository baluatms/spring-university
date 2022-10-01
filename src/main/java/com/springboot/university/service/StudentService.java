package com.springboot.university.service;

import com.springboot.university.exception.StudentNotFoundException;
import com.springboot.university.entity.Student;
import com.springboot.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public Student registerStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) throws StudentNotFoundException {
        List<Student> students = getAllStudents();
        Optional<Student> student = students.stream().filter(s -> s.getId() == id).findFirst();
        if(student.isPresent()) {
            return student.get();
        } else {
            throw new StudentNotFoundException("Student with id : "+id+" is not found");
        }
    }

    public List<Student> getAllStudentInBranch(String branch) {
        List<Student> students = getAllStudents();
        return students.stream().filter(student -> student.getBranch().equalsIgnoreCase(branch)).collect(Collectors.toList());
    }

}
