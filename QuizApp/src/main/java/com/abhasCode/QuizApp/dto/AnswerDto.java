package com.abhasCode.QuizApp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerDto {

    @JsonProperty("answer_a")
    private String answerA;
    @JsonProperty("answer_b")
    private String answerB;

    @JsonProperty("answer_c")
    private String answerC;

    @JsonProperty("answer_d")
    private String answerD;

}
