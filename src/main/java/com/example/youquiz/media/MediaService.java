package com.example.youquiz.media;

import com.example.youquiz.Exception.ResourceNotFoundException;
import com.example.youquiz.question.Question;
import com.example.youquiz.question.QuestionRepository;
import com.example.youquiz.test.Test;
import com.example.youquiz.test.TestDTOReq;
import com.example.youquiz.trainer.Trainer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MediaService implements IMedia{
    @Autowired
    private MediaRepository mediaRepository;


    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    private MediaService(MediaRepository mediaRepository){
        this.mediaRepository=mediaRepository;
    }

    @Override
    public Page<MediaDTORes> findAll(Pageable pageable) {
        Page<Media> medias = mediaRepository.findAll(pageable);
        return medias.map(media -> modelMapper.map(media, MediaDTORes.class));
    }

    @Override
    public MediaDTORes findById(int id) {
        Media media = mediaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        return modelMapper.map(media, MediaDTORes.class);
    }


    @Override
    public MediaDTOReq save(MediaDTOReq mediaDTOReq) {
        Media media= modelMapper.map(mediaDTOReq, Media.class);
        Question question = questionRepository.findById(mediaDTOReq.getQuestion_id())
                .orElseThrow(() -> new ResourceNotFoundException("id : " + mediaDTOReq.getQuestion_id()));
        media.setQuestion(question);
        mediaRepository.save(media);
        return modelMapper.map(media, MediaDTOReq.class);
    }

    @Override
    public MediaDTORes deleteById(int id){
        Media media = mediaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        mediaRepository.deleteById(id);
        return modelMapper.map(media, MediaDTORes.class);
    }

    @Override
    public MediaDTOReq update(MediaDTOReq mediaDTOReq) {
        MediaDTOReq mediaDTOReqnew= new MediaDTOReq();
        Media media = mediaRepository.findById(mediaDTOReq.getId())
                .orElseThrow(() -> new ResourceNotFoundException("id : " + mediaDTOReq.getId()));
        mediaDTOReqnew.setId(media.getId());
        mediaDTOReqnew.setSrc(mediaDTOReq.getSrc());
        mediaDTOReqnew.setMediaType(mediaDTOReq.getMediaType());
        mediaDTOReqnew.setQuestion_id(mediaDTOReq.getQuestion_id());
        mediaRepository.save(modelMapper.map(mediaDTOReqnew, Media.class));
        return modelMapper.map(media, MediaDTOReq.class);
    }
}
