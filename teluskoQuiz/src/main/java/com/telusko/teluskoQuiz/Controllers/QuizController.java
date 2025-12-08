package com.telusko.teluskoQuiz.Controllers;

import com.telusko.teluskoQuiz.Entity.QuestionWrapper;
import com.telusko.teluskoQuiz.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>>getall(@PathVariable Integer id){
       return quizService.getQuizQuestions(id);
    }
    @PostMapping("/create")
    public ResponseEntity<String>createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
        return quizService.createQuiz(category,numQ,title);
    }
}
