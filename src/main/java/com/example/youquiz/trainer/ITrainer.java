package com.example.youquiz.trainer;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITrainer {
    Page<TrainerDTO> findAll(Pageable pageable);
    TrainerDTO findById(int id);
    TrainerDTO save(TrainerDTO trainerDTO);
    TrainerDTO deleteById(int id);
    TrainerDTO update(TrainerDTO trainerDTO);
}
