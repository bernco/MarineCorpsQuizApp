package com.example.jadov.marinecorpsquizapp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jadov on 2/10/2018.
 */

public class CreateQuestion {

    enum answerType {
        checkBox, radioButton, editText, button
    }

    Map questions = new HashMap();

    //Empty constructor for creating a question
    public CreateQuestion() {}

    //Constructor for creating a question of checkbox or radioButton type
    public CreateQuestion(String question, String answerA, String answerB, String answerC, String answerD, String answer, answerType type) {
        questions.put("question", question);
        questions.put("answerA", answerA);
        questions.put("answerB", answerB);
        questions.put("answerC", answerC);
        questions.put("answerD", answerD);
        questions.put("answer", answer);
        questions.put("type", type);
    }

    //Constructor for creating a question of editText type
    public CreateQuestion(String question, String answerA, String answer, answerType type) {
        questions.put("question", question);
        questions.put("answerA", answerA);
        questions.put("answer", answer);
        questions.put("type", type);
    }


}
