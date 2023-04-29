package com.example.demo.database;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class UserDatabase {

    @Autowired
    UserService userService;
    @Bean
    CommandLineRunner runner(UserService userService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/userdata.json");
            try {
                List<User> users = mapper.readValue(inputStream,typeReference);
                for (User user:users) {
                    userService.createUser(user);
                }
                System.out.println("Users Saved!");
            } catch (IOException e){
                System.out.println("Unable to save users: " + e.getMessage());
            }
        };
    }
}
