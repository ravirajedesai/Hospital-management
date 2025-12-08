package com.QuestionService.Question.Repository;

import com.QuestionService.Question.Entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Long> {

    List<Question> findByQuizId(Long quizId);
}
