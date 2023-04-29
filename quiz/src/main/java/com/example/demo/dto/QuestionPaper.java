package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class QuestionPaper {

    public QuestionPaper(){

    }

    List<Qustn> qustns=new ArrayList<>();
    public List<Qustn> getQustns() {
        return qustns;
    }

    public void setQustns(List<Qustn> qustns) {
        this.qustns = qustns;
    }

    @Override
    public String toString() {
        return "QuestionPaper{" +
                "qustns=" + qustns +
                '}';
    }
}
