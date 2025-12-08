package com.QuestionService.Question.Services;

import com.QuestionService.Question.Entities.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
    Question create(Question question);
    List<Question>getAll();
    Question getOne(Long id);
    List<Question>getQuestionOfQuiz(Long quizId);
}
