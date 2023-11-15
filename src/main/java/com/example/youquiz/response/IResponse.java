package com.example.youquiz.response;


import java.util.List;

public interface IResponse {
    List<ResponseDTO> findAll();
    ResponseDTO findById(int id);
    ResponseDTO save(ResponseDTO responseDTO);
    ResponseDTO deleteById(int id);
    ResponseDTO update(ResponseDTO responseDTO);
}
