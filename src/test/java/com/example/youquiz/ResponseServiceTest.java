package com.example.youquiz;

import com.example.youquiz.response.Response;
import com.example.youquiz.response.ResponseDTO;
import com.example.youquiz.response.ResponseRepository;
import com.example.youquiz.response.ResponseService;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
class ResponseServiceTest {
    @Mock
    private ResponseRepository repository;

    @InjectMocks
    private ResponseService service;

    @Mock
    private ModelMapper modelMapper;

    private Response instanse;

    private ResponseDTO instanseDTO;

    @BeforeEach
    public void setUp() {
        instanse = new Response();
        instanse.setTextResponse("test");

        instanseDTO = new ResponseDTO();
        instanse.setTextResponse("test");
    }

    @Test
    public void save() {

        try {
            when(service.save(instanseDTO)).thenReturn(instanseDTO);
            assertEquals(instanseDTO,service.save(instanseDTO));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void update() {
        try {
            given(repository.findById(1)).willReturn(Optional.of(instanse));
            given(modelMapper.map(instanseDTO, Response.class)).willReturn(instanse);
            given(repository.save(instanse)).willReturn(instanse);
            assertSame(instanseDTO.getId(), service.update(instanseDTO).getId());
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
        Pageable pageable = PageRequest.of(0, 2);
        try {
            List<Response> instanses = new ArrayList<>();
            instanses.add(instanse);
            instanses.add(instanse);
            instanses.add(instanse);
            given(repository.findAll()).willReturn(instanses);
            assertEquals(3, service.findAll(pageable).getTotalElements());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
