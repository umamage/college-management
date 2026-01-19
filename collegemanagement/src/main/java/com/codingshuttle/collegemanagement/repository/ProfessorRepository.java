package com.codingshuttle.collegemanagement.repository;

import com.codingshuttle.collegemanagement.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {
}
