package com.practice.quizapp.service;

import com.practice.quizapp.model.Quiz;
import com.practice.quizapp.model.Response;
import com.practice.quizapp.repository.QuestionRepository;
import com.practice.quizapp.repository.QuizeRepository;
import com.practice.quizapp.request.QuestionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizeService {

    @Autowired
    private QuizeRepository quizeRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

          List<Integer> questions = //call the generate url
          Quiz quiz = new Quiz();
          quiz.setTitle(title);
          quiz.setQuestions(questions);
          quizeRepository.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionRequest>> getQuizQuestions(Integer id) {
       Optional<Quiz> quiz = quizeRepository.findById(id);
       List<Question> questionFromDB = quiz.get().getQuestions();
        List<QuestionRequest> questionForUsers = new ArrayList<>();
       for (Question q : questionFromDB) {
           QuestionRequest qr = new QuestionRequest(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
           questionForUsers.add(qr);
       }
        return new ResponseEntity<>(questionForUsers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> response) {
        Quiz quiz = quizeRepository.findById(id).get();
       List<Question> questions = quiz.getQuestions();
        int right = 0;
       int i = 0;
       for (Response r : response) {
           if (r.getResponse().equals(questions.get(i).getRightAnswer()))
               right++;
           i++;
       }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
