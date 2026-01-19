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
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length=50)
    private String title;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="professor_id")
    private Professor professor;

    @JsonIgnore
    @ManyToMany(mappedBy = "subjectList")
    private List<Student> studentList;

    @PreRemove
    private void preRemove() {
        for (Student student : studentList) {
            student.getSubjectList().remove(this);
        }
        studentList.clear();
    }

}
