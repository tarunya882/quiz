package com.example.demo.database;

import com.example.demo.entity.Question;
import com.example.demo.entity.User;
import com.example.demo.service.QuestionService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class QuestionDatabase {
    @Autowired
    QuestionService questionService;
    @Bean
    CommandLineRunner runner1(QuestionService questionService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Question>> typeReference = new TypeReference<List<Question>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/questiondata.json");
            try {
                List<Question> questions = mapper.readValue(inputStream,typeReference);
                for (Question question:questions) {
                    questionService.createQuestion(question);
                }
                System.out.println("QuestionsSaved!");
            } catch (IOException e){
                System.out.println("Unable to save questions: " + e.getMessage());
            }
        };
    }

}
