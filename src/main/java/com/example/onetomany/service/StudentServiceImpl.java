package com.example.onetomany.service;

import com.example.onetomany.dto.ResultDto;
import com.example.onetomany.entity.Student;
import com.example.onetomany.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;
    @Override
    public ResultDto create(Student student) {
        try {
            studentRepository.save(student);
        }catch (Exception e){
            return ResultDto.builder().code(400).message(e.getMessage()).build();
        }
        return ResultDto.builder().code(200).message("thanh cong").build();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
}
