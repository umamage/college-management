package com.codingshuttle.collegemanagement.repository;

import com.codingshuttle.collegemanagement.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}