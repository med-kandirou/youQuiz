package com.example.youquiz;

import com.example.youquiz.validation.Validation;
import com.example.youquiz.validation.ValidationDTOReq;
import com.example.youquiz.validation.ValidationRepository;
import com.example.youquiz.validation.ValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
class ValidationServiceTest {
    @Mock
    private ValidationRepository repository;

    @InjectMocks
    private ValidationService service;

    @Mock
    private ModelMapper modelMapper;


    private Validation instanse;

    private ValidationDTOReq instanseDTOReq;


    @BeforeEach
    public void setUp() {
        instanse = new Validation();
        instanse.setPoint(3);

        instanseDTOReq = new ValidationDTOReq();
        instanseDTOReq.setPoint(3.3);
    }

    @Test
    public void save() {

        try {
            when(service.save(instanseDTOReq)).thenReturn(instanseDTOReq);
            assertEquals(instanseDTOReq,service.save(instanseDTOReq));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void update() {
        try {
            given(repository.findById(1)).willReturn(Optional.of(instanse));
            //given(modelMapper.map(instanseDTOReq, Subject.class)).willReturn(instanseDTOReq);
            given(repository.save(instanse)).willReturn(instanse);
            assertSame(instanseDTOReq.getId(), service.update(instanseDTOReq).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findbyId() {
        given(repository.findById(1)).willReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> service.findById(1));
    }

    @Test
    public void deleteTest() {
        try {
            given(repository.findById(1)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> service.deleteById(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findAll() {
        try {
            List<Validation> instanses = new ArrayList<>();
            instanses.add(instanse);
            instanses.add(instanse);
            instanses.add(instanse);
            given(repository.findAll()).willReturn(instanses);
            assertEquals(3, service.findAll().size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

