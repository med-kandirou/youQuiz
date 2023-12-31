package com.example.youquiz.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Optional<Student> findStudentByFirstNameAndPassword(String firstName, String password);
}
