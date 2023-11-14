package com.example.youquiz.trainer;

import com.example.youquiz.Exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainerService implements ITrainer{
    @Autowired
    private TrainerRepository trainerRepository;
    @Autowired
    private ModelMapper modelMapper;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }


    @Override
    public List<TrainerDTO> findAll() {
        List<Trainer> Trainers = trainerRepository.findAll();
        return Trainers.stream()
                .map(Trainer -> modelMapper.map(Trainer, TrainerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TrainerDTO findById(int id) {
        TrainerDTO trainerDTO = null;
        Optional<Trainer> optTrainer = trainerRepository.findById(id);
        if (!optTrainer.isPresent()) {
            throw new ResourceNotFoundException("id : "+id);
        }
        trainerDTO = modelMapper.map(optTrainer.get(), TrainerDTO.class);
        return trainerDTO;
    }

    @Override
    public TrainerDTO save(TrainerDTO TrainerDTO) {
        Trainer Trainer= modelMapper.map(TrainerDTO, Trainer.class);
        return modelMapper.map(Trainer, TrainerDTO.class);
    }

    @Override
    public TrainerDTO deleteById(int id) {
        TrainerDTO TrainerDTO=null;
        Optional<Trainer> optTrainer=trainerRepository.findById(id);
        if(!optTrainer.isPresent()){
            throw new ResourceNotFoundException("id : "+id);
        }
        trainerRepository.deleteById(id);
        TrainerDTO = modelMapper.map(optTrainer.get(), TrainerDTO.class);
        return TrainerDTO;
    }

    @Override
    public TrainerDTO update(TrainerDTO TrainerDTO) {
        return null;
    }
}
