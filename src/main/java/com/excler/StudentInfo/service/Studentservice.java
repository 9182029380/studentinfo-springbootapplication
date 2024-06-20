package com.excler.StudentInfo.service;

import com.excler.StudentInfo.model.Student;
import com.excler.StudentInfo.repository.Studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.excler.StudentInfo.model.UserInfo;
import com.excler.StudentInfo.repository.UserInfoRepository;

import java.util.List;

@Service
public class Studentservice {
    @Autowired
    private Studentrepository repo;
    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public Student addStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }

    public List<Student> addStudents(List<Student> students) {
        return repo.saveAll(students);
    }

    public Student getStudent(int id) {
        return repo.findById(id).orElse(null);
    }

    public String deleteStudent(int id) {
        repo.deleteById(id);
        return "student deleted successfully";
    }

    public Student updateStudent(int id, Student student) {
        Student existingStudent = repo.findById(id).orElse(null);
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setAddress(student.getAddress());
        repo.save(existingStudent);
        return student;
    }
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system ";
    }
}
