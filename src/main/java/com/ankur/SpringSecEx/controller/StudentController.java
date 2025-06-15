package com.ankur.SpringSecEx.controller;

import com.ankur.SpringSecEx.model.Student;
import com.ankur.SpringSecEx.model.Users;
import com.ankur.SpringSecEx.repo.UserRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private UserRepo userRepo;

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1,"Ankur",12),
            new Student(2,"Aman",23)
    ));

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest req){
        return (CsrfToken) req.getAttribute("_csrf");
    }

    @GetMapping("/students/{username}")
    public Users getStudent(@PathVariable(value = "username") String username){
        return userRepo.findByUsername(username);
    }
    @GetMapping("/students")
    public List<Users> getStudents(){
        return userRepo.findAll();
    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
