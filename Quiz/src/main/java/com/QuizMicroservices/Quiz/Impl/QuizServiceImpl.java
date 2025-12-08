package com.QuizMicroservices.Quiz.Impl;

import com.QuizMicroservices.Quiz.Entity.Quiz;
import com.QuizMicroservices.Quiz.Repository.QuizRepo;
import com.QuizMicroservices.Quiz.Services.QuestionClient;
import com.QuizMicroservices.Quiz.Services.QuizServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class QuizServiceImpl implements QuizServices {

    public QuizRepo quizRepo;

   private QuestionClient questionClient;

    public QuizServiceImpl(QuestionClient questionClient, QuizRepo quizRepo) {
        this.questionClient = questionClient;
        this.quizRepo = quizRepo;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = quizRepo.findAll();
        List<Quiz> newQuizList = quizzes.stream()
                .map(quiz -> {
                    quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
                    return quiz;
                })
                .collect(Collectors.toList()); // collect() returns a List, not a Stream
        return newQuizList;
    }


    @Override
    public Quiz get(Long id) {
        Quiz quiz=quizRepo.findById(id).orElseThrow(()->new RuntimeException("Quiz Not Found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }
}
