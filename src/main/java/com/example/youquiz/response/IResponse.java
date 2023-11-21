package com.example.youquiz.response;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IResponse {
    Page<ResponseDTO> findAll(Pageable pageable);
    ResponseDTO findById(int id);
    ResponseDTO save(ResponseDTO responseDTO);
    ResponseDTO deleteById(int id);
    ResponseDTO update(ResponseDTO responseDTO);
}
