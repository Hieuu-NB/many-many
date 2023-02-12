package com.example.onetomany.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_course", nullable = false)
    private Long id;
    private String nameCourse;

    @ManyToMany(mappedBy = "likedCourse", fetch = FetchType.LAZY)
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonBackReference
    private List<Student> likes;

    public Course(String name_Course) {
        this.nameCourse = name_Course;
    }

}
