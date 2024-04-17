package com.abhasCode.QuizApp.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnsResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("question")
    private String question;

    @JsonProperty("description")
    private String description;

    @JsonProperty("answers")
    private AnswerDto answers;

    @JsonProperty("correct_answers")
    private CorrectAnswersDto correctAnswers;

    @JsonProperty("multipleCorrectAnswers")
    private String multipleCorrectAnswers;

    @JsonProperty("explanation")
    private String explanation;

//    @JsonProperty("tip")
//    private String tip;
//
//    @JsonProperty("tags")
//    private String[] tags;
//
//    @JsonProperty("category")
//    private String category;
//
//    @JsonProperty("difficulty")
//    private String difficulty;

}
