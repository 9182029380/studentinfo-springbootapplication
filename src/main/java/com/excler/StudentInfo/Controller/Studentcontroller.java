package com.excler.StudentInfo.Controller;

import com.excler.StudentInfo.model.Student;
import com.excler.StudentInfo.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.excler.StudentInfo.model.UserInfo;

import java.util.List;

@RestController
@RequestMapping("/excler")
public class Studentcontroller {
    @Autowired
    private Studentservice service;
    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo){
        return service.addUser(userInfo);
    }

    @PostMapping("/addstudent")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }
    @GetMapping("/getstudents")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Student> getStudents(){
        return service.getStudents();
    }
    @PostMapping("/addestudents")
    public List<Student> addStudents(@RequestBody List<Student> students){
        return service.addStudents(students);
    }
    @GetMapping("/getstudent/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Student getStudent(@PathVariable int id){
        return service.getStudent(id);
    }
    @DeleteMapping("/deletestudent/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String deleteStudent(@PathVariable int id){
        return service.deleteStudent(id);
    }
    @PutMapping("/updatestudent/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Student updateStudent(@PathVariable int id,@RequestBody Student student){
        return service.updateStudent(id,student);
    }

}
