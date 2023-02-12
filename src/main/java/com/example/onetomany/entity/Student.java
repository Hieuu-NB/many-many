package com.example.onetomany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_student", nullable = false)
    private Long id;
    private String name;
    private String classroom;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "course_id",referencedColumnName = "id_course"))
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonIgnore
    @JsonManagedReference
    private List<Course> likedCourse;

    public Student(String name, String classroom) {
        this.name = name;
        this.classroom = classroom;
    }
}
