package com.example.youquiz.subject;

import com.example.youquiz.Exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService implements ISubject {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    private SubjectService(SubjectRepository subjectRepository){
        this.subjectRepository=subjectRepository;
    }

    @Override
    public List<SubjectDTOResp> findAll() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream()
                .map(sub -> modelMapper.map(sub, SubjectDTOResp.class))
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDTOResp findById(int id) {
        Subject Subject = subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        return modelMapper.map(Subject, SubjectDTOResp.class);
    }

    @Override
    public SubjectDTOReq save(SubjectDTOReq subjectDTOReq) {
        subjectRepository.findById(subjectDTOReq.getParent_id())
                .orElseThrow(() -> new ResourceNotFoundException("id parent : " + subjectDTOReq.getParent_id()));
        Subject subjectToSave= modelMapper.map(subjectDTOReq, Subject.class);
        subjectRepository.save(subjectToSave);
        return modelMapper.map(subjectToSave, SubjectDTOReq.class);
    }

    @Override
    public SubjectDTOResp deleteById(int id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        subjectRepository.deleteById(id);
        return modelMapper.map(subject, SubjectDTOResp.class);
    }

    @Override
    public SubjectDTOReq update(SubjectDTOReq subjectDTOReq) {
        Subject subject = subjectRepository.findById(subjectDTOReq.getId())
                .orElseThrow(() -> new ResourceNotFoundException("id : " + subjectDTOReq.getId()));
        subject.setTitle(subjectDTOReq.getTitle());
        subjectRepository.save(subject);
        return modelMapper.map(subject, SubjectDTOReq.class);
    }
}
