package com.example.demo.dto;

import java.util.List;

public class Answers {
    private List<String> answers;

    public Answers(){

    }

    public Answers(List<String> answers) {
        this.answers = answers;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Answers{" +
                "answers=" + answers +
                '}';
    }
}
