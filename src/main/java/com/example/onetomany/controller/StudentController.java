package com.example.onetomany.controller;

import com.example.onetomany.entity.Course;
import com.example.onetomany.entity.Student;
import com.example.onetomany.service.CourseService;
import com.example.onetomany.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final CourseService courseService;
//    @PutMapping(value = "/create_Student",consumes = "application/json;charset=UTF-8")
//    public ResponseEntity<Object> create(@RequestBody Student student){
//        return ResponseEntity.ok(studentService.create(student));
//    }
    //  thêm dữ liệu cho sinh viên , 1 sinh viên học nhiều môn
    @GetMapping("/abc")
    public void tao(){
        Course course1 = new Course("toan");
        Course course2 = new Course("ly");
        Student student = new Student("Dinh Minh Hieu","it2");
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        student.setLikedCourse(courses);
        studentService.save(student);
    }
    // tạo dữ liệu 1 môn học có nhiều sinh viên học
    @GetMapping("/createCourse")
    public void taoCourse(){
        Student student1 = new Student("Dinh Minh A","it1");
        Student student2 = new Student("Dinh Minh B","it2");
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        Course course = new Course("C++");
        course.setLikes(students);
        courseService.save(course);
    }
}
