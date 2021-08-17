package com.example.appcrudstudent.repository;

import com.example.appcrudstudent.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    boolean existsByName(String name);


}
