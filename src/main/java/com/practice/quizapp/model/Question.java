package com.practice.quizapp.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String category;

    private String difficultylevel;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    private String questionTitle;

    private String rightAnswer;

}
