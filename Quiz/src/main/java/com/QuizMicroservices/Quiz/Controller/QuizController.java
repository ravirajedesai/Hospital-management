package com.QuizMicroservices.Quiz.Controller;

import com.QuizMicroservices.Quiz.Entity.Quiz;
import com.QuizMicroservices.Quiz.Services.QuizServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizServices quizServices;

    public QuizController(QuizServices quizServices) {
        this.quizServices = quizServices;
    }
    @PostMapping
    public Quiz create(@RequestBody Quiz quiz){
        return quizServices.add(quiz);
    }
    @GetMapping
    public List<Quiz>get(){
        return quizServices.get();
    }
    @GetMapping("/{id}")
    public Quiz getById(@PathVariable Long id){
        return quizServices.get(id);
    }
}
