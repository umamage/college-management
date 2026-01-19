package com.codingshuttle.collegemanagement.controller;

import com.codingshuttle.collegemanagement.entities.Subject;
import com.codingshuttle.collegemanagement.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @PostMapping
    public Subject create(@RequestBody Subject subject) {
        return subjectService.createSubject(subject);
    }

    @GetMapping
    public List<Subject> getAll() {
        return subjectService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        subjectService.delete(id);
    }
}
