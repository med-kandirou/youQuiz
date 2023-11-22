
package com.example.youquiz;

import com.example.youquiz.student.Student;
import com.example.youquiz.student.StudentDTO;
import com.example.youquiz.student.StudentRepository;
import com.example.youquiz.student.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Mock
    private ModelMapper modelMapper;


    private Student student;

    private StudentDTO studentDto;


    @BeforeEach
    public void setUp() {
        student = new Student();
        student.setFirstName("first name");
        student.setLastName("last name");

        studentDto = new StudentDTO();
        studentDto.setFirstName("first name");
        studentDto.setLastName("last name");

    }

    @Test
    public void save() {

        try {
            when(studentService.save(studentDto)).thenReturn(studentDto);
            assertEquals(studentDto,studentService.save(studentDto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void update() {
        try {
            given(studentRepository.findById(1)).willReturn(Optional.of(student));
            given(modelMapper.map(studentDto, Student.class)).willReturn(student);
            given(studentRepository.save(student)).willReturn(student);
            assertSame(studentDto.getCode(), studentService.update(studentDto).getCode());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findbyId() {

        given(studentRepository.findById(1)).willReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> studentService.findById(1));

    }

    @Test
    public void deleteTest() {
        try {
            given(studentRepository.findById(1)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> studentService.deleteById(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findAll() {
        Pageable pageable = PageRequest.of(0, 2);
        try {
            List<Student> Students = new ArrayList<>();
            Students.add(student);
            Students.add(student);
            Students.add(student);
            given(studentRepository.findAll()).willReturn(Students);
            assertEquals(3, studentService.findAll(pageable).getTotalElements());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
