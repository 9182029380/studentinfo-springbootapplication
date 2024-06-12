package com.excler.StudentInfo.Controller;

import com.excler.StudentInfo.model.Student;
import com.excler.StudentInfo.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/excler")
public class Studentcontroller {
    @Autowired
    private Studentservice service;

    @PostMapping("/addstudent")
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }
    @GetMapping("/getstudents")
    public List<Student> getStudents(){
        return service.getStudents();
    }
    @PostMapping("/addestudents")
    public List<Student> addStudents(@RequestBody List<Student> students){
        return service.addStudents(students);
    }
    @GetMapping("/getstudent/{id}")
    public Student getStudent(@PathVariable int id){
        return service.getStudent(id);
    }
    @DeleteMapping("/deletestudent/{id}")
    public String deleteStudent(@PathVariable int id){
        return service.deleteStudent(id);
    }
    @PutMapping("/updatestudent/{id}")
    public Student updateStudent(@PathVariable int id,@RequestBody Student student){
        return service.updateStudent(id,student);
    }

}
