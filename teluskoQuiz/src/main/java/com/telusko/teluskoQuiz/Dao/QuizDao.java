package com.telusko.teluskoQuiz.Dao;

import com.telusko.teluskoQuiz.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
    Optional<Quiz> findAllById(Integer id);
}
