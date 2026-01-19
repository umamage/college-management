package com.codingshuttle.collegemanagement.service;

import com.codingshuttle.collegemanagement.entities.Professor;
import com.codingshuttle.collegemanagement.entities.Student;
import com.codingshuttle.collegemanagement.entities.Subject;
import com.codingshuttle.collegemanagement.repository.ProfessorRepository;
import com.codingshuttle.collegemanagement.repository.StudentRepository;
import com.codingshuttle.collegemanagement.repository.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

private final ProfessorRepository professorRepository;
private final StudentRepository studentRepository;
private final SubjectRepository subjectRepository;

public Professor createProfessor(Professor professor) {
    return professorRepository.save(professor);
}

public Professor assignStudent(Long professorId, Long studentId) {
    Professor professor = professorRepository.findById(professorId)
            .orElseThrow(() -> new RuntimeException("Professor not found"));
    Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found"));

    professor.getStudentList().add(student);
    student.getProfessorList().add(professor);

    return professorRepository.save(professor);
}

public Professor assignSubject(Long professorId, Long subjectId) {
    Professor professor = professorRepository.findById(professorId)
            .orElseThrow(() -> new RuntimeException("Professor not found"));
    Subject subject = subjectRepository.findById(subjectId)
            .orElseThrow(() -> new RuntimeException("Subject not found"));

    professor.getSubjectList().add(subject);
    subject.setProfessor(professor);

    return professorRepository.save(professor);
}

public List<Professor> findAll() {
    return professorRepository.findAll();
}
@Transactional
public void delete(Long id) {

    Professor professor = professorRepository.findById(id)
            .orElseThrow(EntityNotFoundException::new);

    professor.getStudentList().clear();
    professorRepository.delete(professor);
}
}