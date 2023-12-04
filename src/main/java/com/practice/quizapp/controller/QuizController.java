package com.practice.quizapp.controller;

import com.practice.quizapp.model.QuizDTO;
import com.practice.quizapp.model.Response;
import com.practice.quizapp.request.QuestionRequest;
import com.practice.quizapp.service.QuizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizeService quizeService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDTO){
        return quizeService.createQuiz(quizDTO.getCategoryName(),quizDTO.getNumQuestion(),quizDTO.getTitle());
    }

    @GetMapping("get/{id}")
    public  ResponseEntity<List<QuestionRequest>>getQuizQuestions(@PathVariable Integer id){
        return quizeService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public  ResponseEntity<Integer>submitQuiz(@PathVariable Integer id,@RequestBody List<Response> response){
        return quizeService.calculateResult(id,response);
    }
}
