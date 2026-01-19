package com.codingshuttle.collegemanagement.service;

import com.codingshuttle.collegemanagement.entities.Student;
import com.codingshuttle.collegemanagement.entities.Subject;
import com.codingshuttle.collegemanagement.repository.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        Subject subject = subjectRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        for (Student student : subject.getStudentList()) {
            student.getSubjectList().remove(subject);
        }
        subject.getStudentList().clear();
        subjectRepository.delete(subject);
    }
}
