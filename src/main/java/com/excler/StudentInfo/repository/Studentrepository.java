package com.excler.StudentInfo.repository;

import com.excler.StudentInfo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  Studentrepository  extends JpaRepository<Student,Integer> {
}
