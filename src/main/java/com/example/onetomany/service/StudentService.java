package com.example.onetomany.service;

import com.example.onetomany.dto.ResultDto;
import com.example.onetomany.entity.Student;

public interface StudentService {
    ResultDto create(Student student);
    void save(Student student);
}
