package com.example.youquiz.assignment;

import com.example.youquiz.Exception.ResourceNotFoundException;
import com.example.youquiz.level.Level;
import com.example.youquiz.level.LevelDTO;
import com.example.youquiz.question.Question;
import com.example.youquiz.question.QuestionDTOReq;
import com.example.youquiz.student.Student;
import com.example.youquiz.student.StudentRepository;
import com.example.youquiz.subject.Subject;
import com.example.youquiz.trainer.Trainer;
import com.example.youquiz.trainer.TrainerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentService implements IAssignement{

    private final AssignmentRepository assignmentRepository;
    private final StudentRepository studentRepository;
    private final TrainerRepository trainerRepository;
    private final ModelMapper modelMapper;

    public AssignmentService(AssignmentRepository assignmentRepository, StudentRepository studentRepository, TrainerRepository trainerRepository, ModelMapper modelMapper) {
        this.assignmentRepository = assignmentRepository;
        this.studentRepository = studentRepository;
        this.trainerRepository = trainerRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<AssignementTDORes> findAll() {
        List<Assignment> assignments = assignmentRepository.findAll();
        return assignments.stream()
                .map(assi -> modelMapper.map(assi, AssignementTDORes.class))
                .collect(Collectors.toList());
    }

    @Override
    public AssignementTDORes findById(int id) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        return modelMapper.map(assignment, AssignementTDORes.class);
    }

    @Override
    public AssignementTDOReq save(AssignementTDOReq assignementTDOReq) {
        Assignment assignment= modelMapper.map(assignementTDOReq, Assignment.class);
        Trainer trainer = trainerRepository.findById(assignementTDOReq.getTrainer_id())
                .orElseThrow(() -> new ResourceNotFoundException("id : " + assignementTDOReq.getTrainer_id()));
        Student student = studentRepository.findById(assignementTDOReq.getStudent_id())
                .orElseThrow(() -> new ResourceNotFoundException("id : " + assignementTDOReq.getStudent_id()));
        assignment.setStudent(student);
        assignment.setTrainer(trainer);
        assignmentRepository.save(assignment);
        return modelMapper.map(assignment, AssignementTDOReq.class);
    }

    @Override
    public AssignementTDORes deleteById(int id) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        assignmentRepository.deleteById(id);
        return modelMapper.map(assignment, AssignementTDORes.class);
    }

    @Override
    public AssignementTDOReq update(AssignementTDOReq assignementTDOReq) {
        return null;
    }
}
