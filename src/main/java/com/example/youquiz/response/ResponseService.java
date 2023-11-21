package com.example.youquiz.response;

import com.example.youquiz.Exception.ResourceNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResponseService implements IResponse{
    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private ModelMapper modelMapper;

    private ResponseService(ResponseRepository responseRepository){
        this.responseRepository=responseRepository;
    }
    
    @Override
    public Page<ResponseDTO> findAll(Pageable pageable) {
        Page<Response> responses = responseRepository.findAll(pageable);
        return responses.map(response -> modelMapper.map(response, ResponseDTO.class));
    }

    public ResponseDTO findById(int id) {
        Response response = responseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        return modelMapper.map(response, ResponseDTO.class);
    }

    @Override
    public ResponseDTO save(ResponseDTO responseDTO) {
        Response response= modelMapper.map(responseDTO, Response.class);
        responseRepository.save(response);
        return modelMapper.map(response, ResponseDTO.class);
    }


    public ResponseDTO deleteById(int id){
        Response response = responseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        responseRepository.deleteById(id);
        return modelMapper.map(response, ResponseDTO.class);
    }

    @Override
    public ResponseDTO update(ResponseDTO responseDTO) {
        Response response = responseRepository.findById(responseDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("id : " + responseDTO.getId()));
        response.setTextResponse(responseDTO.getTextResponse());
        responseRepository.save(response);
        return modelMapper.map(response, ResponseDTO.class);
    }

}
