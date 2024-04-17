package com.abhasCode.QuizApp.config;


import com.abhasCode.QuizApp.dto.AnsResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface QuizApiFeignClient {

    @RequestLine("GET /questions?apiKey={apiKey}")
    @Headers({"Content-Type: application/json"})
    List<AnsResponse> getQuestions(@Param("apiKey") String apiKey);

//    @RequestMapping(method = RequestMethod.GET, value = "/tags")
//    List<Post> getTags(@RequestParam("apiKey") String apiKey);
//
//    @RequestMapping(method = RequestMethod.GET, value = "/categories")
//    List<Post> getCategories(@RequestParam("apiKey") String apiKey);

//    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
//    Post getPostById(@PathVariable("postId") Long postId);
}