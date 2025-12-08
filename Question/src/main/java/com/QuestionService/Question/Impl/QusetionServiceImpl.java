package com.QuestionService.Question.Impl;

import com.QuestionService.Question.Entities.Question;
import com.QuestionService.Question.Repository.QuestionRepo;
import com.QuestionService.Question.Services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QusetionServiceImpl implements QuestionService {

    QuestionRepo questionRepo;

    public QusetionServiceImpl(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @Override
    public Question create(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public List<Question> getAll() {
        return questionRepo.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRepo.findById(id).orElseThrow(()->new RuntimeException("Question Not Found.."));
    }

    @Override
    public List<Question> getQuestionOfQuiz(Long quizId) {
        return questionRepo.findByQuizId(quizId);
    }
}
