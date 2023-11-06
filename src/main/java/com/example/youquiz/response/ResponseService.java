package com.example.youquiz.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ResponseService {
    @Autowired
    private ResponseRepository responseRepository;

    private ResponseService(ResponseRepository responseRepository){
        this.responseRepository=responseRepository;
    }

    public List<Response> getAll(){
        return responseRepository.findAll();
    }

    public Response findById(int id) throws Exception {
        Optional<Response> optional=responseRepository.findById(id);
        if(!optional.isPresent()){
            throw new IllegalStateException("response not found");
        }
        return optional.get();
    }


    public void deleteById(int id){
        responseRepository.deleteById(id);
    }

    public Response save(Response response){
        return responseRepository.save(response);
    }

}
