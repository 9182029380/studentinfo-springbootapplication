package com.excler.StudentInfo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="studentsinfo")
public class Student {
    @Id
    public Integer id;
    public String name;
    public String fathername;
    public String mothername;
    public String aadharcardnumber;
    public String address;
    public String education;
    public String employeestatus;
    public List<String> skills;
    public String state;
    public String country;
    public String gender;
    public int age;
    public Date dob;
}
