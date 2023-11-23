package com.example.youquiz.assignment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment,Integer> {
    boolean existsByTestIdAndStudentCode(int testId, int studentCode);
}
