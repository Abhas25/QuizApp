package com.abhasCode.QuizApp.config;

import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.Target;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.json.Jackson2JsonEncoder;

@Configuration
public class FeignClientConfig {

    @Bean
    public QuizApiFeignClient elementsAccountingClient(){
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .options(new Request.Options(10000, 10000))
                .retryer(Retryer.NEVER_RETRY)
                .target(new Target.HardCodedTarget<>(QuizApiFeignClient.class, "https://quizapi.io/api/v1/"));
    }

}
