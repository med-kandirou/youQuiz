package com.example.youquiz.trainer;

import com.example.youquiz.student.StudentDTO;

import java.util.List;

public interface ITrainer {
    List<TrainerDTO> findAll();
    TrainerDTO findById(int id);
    TrainerDTO save(TrainerDTO trainerDTO);
    TrainerDTO deleteById(int id);
    TrainerDTO update(TrainerDTO trainerDTO);
}
