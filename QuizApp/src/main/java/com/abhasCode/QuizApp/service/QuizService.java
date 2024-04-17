package com.abhasCode.QuizApp.service;

import com.abhasCode.QuizApp.config.QuizApiFeignClient;
import com.abhasCode.QuizApp.dto.AnsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizApiFeignClient quizApiFeignClient;

    @Value("${api.key}")
    private String apiKey;

    public List<AnsResponse> getQuestions(){
        String[] tags = {"Linux"};
        List<AnsResponse> ansResponses = quizApiFeignClient.getQuestions(apiKey);
        for(AnsResponse resp : ansResponses){
            System.out.println(resp);
        }
        return ansResponses;
    }

}
