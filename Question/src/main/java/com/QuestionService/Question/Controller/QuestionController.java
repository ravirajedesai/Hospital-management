package com.QuestionService.Question.Controller;


import com.QuestionService.Question.Entities.Question;
import com.QuestionService.Question.Services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @PostMapping
    public Question create(@RequestBody Question question){
        return questionService.create(question);
    }
    @GetMapping
    public List<Question>getAllQuestion(){
        return questionService.getAll();
    }
    @GetMapping("/{questionid}")
    public Question getById(@PathVariable Long questionid){
        return questionService.getOne(questionid);
    }
    @GetMapping("quiz/{quizId}")
    List<Question>getQuestionsOfQuiz(@PathVariable Long quizId){
        return questionService.getQuestionOfQuiz(quizId);

    }
}
