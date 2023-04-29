package com.example.demo.controller;

import com.example.demo.dto.Answers;
import com.example.demo.dto.QuestionPaper;
import com.example.demo.dto.Qustn;
import com.example.demo.entity.User;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuizController {

    @Autowired
    QuestionService questionService;

    @RequestMapping("/")
    public String home(){
        return "homepage";
    }

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "loginform";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "showQuiz";
    }

    @RequestMapping("/generateQuiz")
    public String generateQuiz( Model model1,Model model2){
        List<Qustn> questionList=questionService.generateQuiz();
        List<String>ans=new ArrayList<>();
        Answers answers=new Answers();
        for (Qustn q:questionList){
            ans.add(q.getCorrectanswer());
        }
        model2.addAttribute("ca",answers);
        QuestionPaper questionPaper=new QuestionPaper();
        questionPaper.setQustns(questionList);
        model1.addAttribute("questionPaper",questionPaper);
        return "quizpage";
    }


    @RequestMapping("/answerForm")
    public String answerForm(@ModelAttribute ("questionPaper") QuestionPaper questionPaper, Model model) {
      List<Qustn>qustns=questionPaper.getQustns();
      int score=0;
      for(Qustn qustn:qustns){
          if((qustn.getCorrectanswer().equals(qustn.getUseranswer()))){
              score++;
          }
      }
      model.addAttribute("score",score);
      return "result";
    }

}
