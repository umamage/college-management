package com.codingshuttle.collegemanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length=20)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "studentList")
    private List<Professor> professorList;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="student_subject",joinColumns = @JoinColumn(name="student_id"), inverseJoinColumns = @JoinColumn(name="subject_id"))
    private List<Subject> subjectList;

    @JsonIgnore
    @OneToOne(mappedBy = "student", orphanRemoval = true)
    private AdmissionRecord admissionRecord;
}
