package com.example.youquiz;

import com.example.youquiz.media.Media;
import com.example.youquiz.media.MediaDTOReq;
import com.example.youquiz.media.MediaRepository;
import com.example.youquiz.media.MediaService;
import com.example.youquiz.temporisation.Temporisation;
import com.example.youquiz.temporisation.TemporisationDTOReq;
import com.example.youquiz.temporisation.TemporisationRepository;
import com.example.youquiz.temporisation.TemporisationService;
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
class MediaServiceTest {
    @Mock
    private MediaRepository repository;

    @InjectMocks
    private MediaService service;

    @Mock
    private ModelMapper modelMapper;


    private Media instanse;

    private MediaDTOReq instanseDTOReq;


    @BeforeEach
    public void setUp() {
        instanse = new Media();
        instanse.setSrc("source");

        instanseDTOReq = new MediaDTOReq();
        instanseDTOReq.setSrc("source");
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
            List<Media> instanses = new ArrayList<>();
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

