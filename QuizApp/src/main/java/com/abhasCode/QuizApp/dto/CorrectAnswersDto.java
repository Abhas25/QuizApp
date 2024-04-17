package com.abhasCode.QuizApp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CorrectAnswersDto {

    @JsonProperty("answer_a_correct")
    private String answerACorrect;

    @JsonProperty("answer_b_correct")
    private String answerBCorrect;

    @JsonProperty("answer_c_correct")
    private String answerCCorrect;

    @JsonProperty("answer_d_correct")
    private String answerDCorrect;

}
