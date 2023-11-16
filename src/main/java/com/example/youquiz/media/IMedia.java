package com.example.youquiz.media;

import java.util.List;

public interface IMedia {
    List<MediaDTORes> findAll();
    MediaDTORes findById(int id);
    MediaDTOReq save(MediaDTOReq mediaDTOReq);
    MediaDTORes deleteById(int id);
    MediaDTOReq update(MediaDTOReq mediaDTOReq);
}
