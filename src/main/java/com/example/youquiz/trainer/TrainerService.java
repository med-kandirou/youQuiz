package com.example.youquiz.trainer;

import com.example.youquiz.Exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        return modelMapper.map(trainer, TrainerDTO.class);
    }

    @Override
    public TrainerDTO save(TrainerDTO TrainerDTO) {
        Trainer Trainer= modelMapper.map(TrainerDTO, Trainer.class);
        return modelMapper.map(Trainer, TrainerDTO.class);
    }

    @Override
    public TrainerDTO deleteById(int id) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        trainerRepository.deleteById(id);
        return modelMapper.map(trainer, TrainerDTO.class);
    }

    @Override
    public TrainerDTO update(TrainerDTO trainerDTO) {
        Trainer trainer = trainerRepository.findById(trainerDTO.getMatricule())
                .orElseThrow(() -> new ResourceNotFoundException("id : " + trainerDTO.getMatricule()));
        trainer.setFirstName(trainerDTO.getFirstName());
        trainer.setLastName(trainerDTO.getLastName());
        trainer.setAdresse(trainerDTO.getAdresse());
        trainer.setSpecialite(trainerDTO.getSpecialite());
        trainerRepository.save(trainer);
        return modelMapper.map(trainer, TrainerDTO.class);
    }
}
