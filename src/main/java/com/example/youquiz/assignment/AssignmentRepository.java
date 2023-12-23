package com.example.youquiz.assignment;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment,Integer> {
    boolean existsByTestIdAndStudentCode(int testId, int studentCode);

    @Query("SELECT a FROM Assignment a WHERE a.student.code = ?1 AND a.passed = ?2")
    List<Assignment> findAssignmentByStudent(Integer code, boolean isPassed);
}
