package com.abhasCode.QuizApp.controller;

import com.abhasCode.QuizApp.dto.AnsResponse;
import com.abhasCode.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/tags")
    public ResponseEntity<List<AnsResponse>> getTags(){
        quizService.getQuestions();
        return new ResponseEntity<>(quizService.getQuestions() , HttpStatusCode.valueOf(200));

    }
}
