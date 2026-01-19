package com.codingshuttle.collegemanagement.repository;

import com.codingshuttle.collegemanagement.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}