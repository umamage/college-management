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
public class Professor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length=50)
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "professor", orphanRemoval = true)
    private List<Subject> subjectList;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="professor_student",joinColumns = @JoinColumn(name="professor_id"), inverseJoinColumns = @JoinColumn(name="student_id"))
    private List<Student> studentList;

}
