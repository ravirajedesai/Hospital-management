package com.QuizMicroservices.Quiz.Services;

import com.QuizMicroservices.Quiz.Entity.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizServices {
    Quiz add(Quiz quiz);
    List<Quiz>get();
    Quiz get(Long id);
}
