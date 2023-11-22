
package com.example.youquiz;

import com.example.youquiz.trainer.Trainer;
import com.example.youquiz.trainer.TrainerDTO;
import com.example.youquiz.trainer.TrainerRepository;
import com.example.youquiz.trainer.TrainerService;
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
class TrainerServiceTest {
    @Mock
    private TrainerRepository trainerRepository;

    @InjectMocks
    private TrainerService TrainerService;

    @Mock
    private ModelMapper modelMapper;


    private Trainer trainer;

    private TrainerDTO trainerDto;
    

    @BeforeEach
    public void setUp() {
        trainer = new Trainer();
        trainer.setFirstName("first name");
        trainer.setLastName("last name");

        trainerDto = new TrainerDTO();
        trainerDto.setFirstName("first name");
        trainerDto.setLastName("last name");
        
    }

    @Test
    public void save() {

        try {
            when(TrainerService.save(trainerDto)).thenReturn(trainerDto);
            assertEquals(trainerDto, TrainerService.save(trainerDto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void update() {
        try {
            given(trainerRepository.findById(1)).willReturn(Optional.of(trainer));
            given(modelMapper.map(trainerDto, Trainer.class)).willReturn(trainer);
            given(trainerRepository.save(trainer)).willReturn(trainer);
            assertSame(trainerDto.getMatricule(), TrainerService.update(trainerDto).getMatricule());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findbyId() {

        given(trainerRepository.findById(1)).willReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> TrainerService.findById(1));

    }

    @Test
    public void deleteTest() {
        try {
            given(trainerRepository.findById(1)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> TrainerService.deleteById(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findAll() {
        Pageable pageable = PageRequest.of(0, 2);
        try {
            List<Trainer> trainers = new ArrayList<>();
            trainers.add(trainer);
            trainers.add(trainer);
            trainers.add(trainer);
            given(trainerRepository.findAll()).willReturn(trainers);
            assertEquals(3, TrainerService.findAll(pageable).getTotalElements());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
