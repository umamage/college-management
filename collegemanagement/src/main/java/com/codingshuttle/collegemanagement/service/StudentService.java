package com.codingshuttle.collegemanagement.service;

import com.codingshuttle.collegemanagement.entities.Student;
import com.codingshuttle.collegemanagement.entities.Subject;
import com.codingshuttle.collegemanagement.entities.AdmissionRecord;
import com.codingshuttle.collegemanagement.repository.AdmissionRecordRepository;
import com.codingshuttle.collegemanagement.repository.StudentRepository;
import com.codingshuttle.collegemanagement.repository.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

        private final StudentRepository studentRepository;
        private final SubjectRepository subjectRepository;
        private final AdmissionRecordRepository admissionRecordRepository;

        public Student createStudent(Student student) {
            return studentRepository.save(student);
        }

        public Student enrollSubject(Long studentId, Long subjectId) {
            Student student = studentRepository.findById(studentId)
                    .orElseThrow(() -> new RuntimeException("Student not found"));
            Subject subject = subjectRepository.findById(subjectId)
                    .orElseThrow(() -> new RuntimeException("Subject not found"));

            student.getSubjectList().add(subject);
            subject.getStudentList().add(student);

            return studentRepository.save(student);
        }

        public AdmissionRecord createAdmission(Long studentId, Integer fees) {
            Student student = studentRepository.findById(studentId)
                    .orElseThrow(() -> new RuntimeException("Student not found"));

            AdmissionRecord record = new AdmissionRecord();
            record.setFees(fees);
            record.setStudent(student);

            return admissionRecordRepository.save(record);
        }

        public List<Student> findAll() {
            return studentRepository.findAll();
        }

        public void delete(Long id) {
            Student student = studentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            student.getSubjectList().clear();
            student.getProfessorList().clear();
            studentRepository.delete(student);
        }
}

