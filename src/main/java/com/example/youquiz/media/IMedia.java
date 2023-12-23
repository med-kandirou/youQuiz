package com.example.youquiz.media;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IMedia {
    Page<MediaDTORes> findAll(Pageable pageable);
    MediaDTORes findById(int id);
    MediaDTOReq save(MediaDTOReq mediaDTOReq);
    MediaDTORes deleteById(int id);
    MediaDTOReq update(MediaDTOReq mediaDTOReq);
}
