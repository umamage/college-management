package com.codingshuttle.collegemanagement.controller;

import com.codingshuttle.collegemanagement.entities.Professor;
import com.codingshuttle.collegemanagement.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    @PostMapping
    public Professor create(@RequestBody Professor professor) {
        return professorService.createProfessor(professor);
    }

    @PostMapping("/{professorId}/students/{studentId}")
    public Professor assignStudent(
            @PathVariable Long professorId,
            @PathVariable Long studentId) {
        return professorService.assignStudent(professorId, studentId);
    }

    @PostMapping("/{professorId}/subjects/{subjectId}")
    public Professor assignSubject(
            @PathVariable Long professorId,
            @PathVariable Long subjectId) {
        return professorService.assignSubject(professorId, subjectId);
    }

    @GetMapping
    public List<Professor> getAll() {
        return professorService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        professorService.delete(id);
    }
}
