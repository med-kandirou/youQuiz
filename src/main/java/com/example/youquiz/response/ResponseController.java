package com.example.youquiz.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Response")
public class ResponseController {
    @Autowired
    private ResponseService responseService;

    private ResponseController(ResponseService ResponseServise){
        this.responseService=ResponseServise;
    }

    @GetMapping
    public List<Response> getAll(){
        return responseService.getAll();
    }

    @PostMapping
    public Response save(@RequestBody Response response){
        return responseService.save(response);
    }

    @GetMapping(path = {"{responseId}"})
    public Response findById(@PathVariable("responseId") Integer id){
        try {
            return responseService.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(path = {"{responseId}"})
    public void deleteById(@PathVariable("responseId") Integer id){
        try {
            responseService.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
