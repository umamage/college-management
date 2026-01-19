package com.codingshuttle.collegemanagement.controller;

import com.codingshuttle.collegemanagement.entities.AdmissionRecord;
import com.codingshuttle.collegemanagement.entities.Student;
import com.codingshuttle.collegemanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PostMapping("/{studentId}/subjects/{subjectId}")
    public Student enrollSubject(
            @PathVariable Long studentId,
            @PathVariable Long subjectId) {
        return studentService.enrollSubject(studentId, subjectId);
    }

    @PostMapping("/{studentId}/admission")
    public AdmissionRecord createAdmission(
            @PathVariable Long studentId,
            @RequestParam Integer fees) {
        return studentService.createAdmission(studentId, fees);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
