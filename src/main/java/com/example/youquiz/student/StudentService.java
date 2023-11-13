package com.example.youquiz.student;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.IllegalFormatException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudent{

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<StudentDTO> findAll() {
        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO findById(int id) {
        StudentDTO studentDTO=null;
        Optional<Student> optstudent=studentRepository.findById(id);
        if(!optstudent.isPresent()){
            throw new IllegalStateException("ressource not found");
        }
        studentDTO = modelMapper.map(optstudent.get(), StudentDTO.class);
        return studentDTO;
    }

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        Student student= modelMapper.map(studentDTO, Student.class);
        if(studentRepository.save(student)==null){
            throw new IllegalStateException("error in insertion");
        }
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO deleteById(int id) {
        StudentDTO studentDTO=null;
        Optional<Student> optstudent=studentRepository.findById(id);
        if(!optstudent.isPresent()){
            throw new IllegalStateException("ressource not found");
        }
        studentRepository.deleteById(id);
        studentDTO = modelMapper.map(optstudent.get(), StudentDTO.class);
        return studentDTO;
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO) {
        return null;
    }
}
