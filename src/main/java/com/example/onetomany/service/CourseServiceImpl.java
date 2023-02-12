package com.example.onetomany.service;

import com.example.onetomany.entity.Course;
import com.example.onetomany.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;
    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }
}
