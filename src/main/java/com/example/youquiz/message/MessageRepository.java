package com.example.youquiz.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {

    @Query("SELECT m FROM Message m WHERE m.participate.participateID.room.id = :salleId")
    List<Message> findMessagesByRoomId(@Param("salleId") Integer salleId);
}
