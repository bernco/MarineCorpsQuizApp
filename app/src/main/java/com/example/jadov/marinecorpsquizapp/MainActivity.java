package com.example.jadov.marinecorpsquizapp;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int score = 0;
    private int question1, question2, question3, question4, question5, quizResults;
    private CheckBox question1Answer1, question1Answer2, question4Answer1, question4Answer2, question4Answer3;
    private RadioButton question2Answer, question5Answer;
    private EditText question3Answer;
    private int main = R.layout.activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(main);
        question1 = R.layout.question_1;
        question2 = R.layout.question_2;
        question3 = R.layout.question_3;
        question4 = R.layout.question_4;
        question5 = R.layout.question_5;
        quizResults = R.layout.quiz_results;
    }

    public void startQuiz(View view) {
        setContentView(question1);
    }

    public void submitQuestion1(View view) {
        question1Answer1 = findViewById(R.id.question_1b);
        question1Answer2 = findViewById(R.id.question_1c);
        boolean selectQuestion1Answer1 = question1Answer1.isChecked();
        boolean selectQuestion1Answer2 = question1Answer2.isChecked();
        if (selectQuestion1Answer1 && selectQuestion1Answer2) {
            score += 1;
            Toast.makeText(this, "You received 1 bullet. Total bullets received so far: " +
                    score  + "/5", Toast.LENGTH_SHORT).show();
            setContentView(question2);
            return;
        }
        else {
            Toast.makeText(this, "You received 0 bullets. Total bullets received so far: " +
                    score  + "/5", Toast.LENGTH_SHORT).show();
            setContentView(question2);
            return;
        }

    }

    public void submitQuestion2(View view) {
        question2Answer = findViewById(R.id.question_2d);
        boolean selectQuestion2Answer = question2Answer.isChecked();
        if (selectQuestion2Answer) {
            score += 1;
            Toast.makeText(this, "You received 1 bullet. Total bullets received so far: " +
                    score  + "/5", Toast.LENGTH_SHORT).show();
            setContentView(question3);
            return;
        }
        else {
            Toast.makeText(this, "You received 0 bullets. Total bullets received so far: " +
                    score  + "/5", Toast.LENGTH_SHORT).show();
            setContentView(question3);
            return;
        }
    }

    public void submitQuestion3(View view) {
        question3Answer = findViewById(R.id.question_3_answer);
        String enterQuestion3Answer = question3Answer.getText().toString();
        if (enterQuestion3Answer.equals("11/10/1775")) {
            score += 1;
            Toast.makeText(this, "You received 1 bullet. Total bullets received so far: " +
                    score  + "/5", Toast.LENGTH_SHORT).show();
            setContentView(question4);
            return;
        }
        else {
            Toast.makeText(this, "You received 0 bullets. Total bullets received so far: " +
                    score  + "/5", Toast.LENGTH_SHORT).show();
            setContentView(question4);
            return;
        }
    }

    public void submitQuestion4(View view) {
        question4Answer1 = findViewById(R.id.question_4a);
        question4Answer2 = findViewById(R.id.question_4c);
        question4Answer3 = findViewById(R.id.question_4d);
        boolean selectQuestion4Answer1 = question4Answer1.isChecked();
        boolean selectQuestion4Answer2 = question4Answer2.isChecked();
        boolean selectQuestion4Answer3 = question4Answer3.isChecked();
        if (selectQuestion4Answer1 && selectQuestion4Answer2 && selectQuestion4Answer3) {
            score += 1;
            Toast.makeText(this, "You received 1 bullet. Total bullets received so far: " +
                    score  + "/5", Toast.LENGTH_SHORT).show();
            setContentView(question5);
            return;
        }
        else {
            Toast.makeText(this, "You received 0 bullets. Total bullets received so far: " +
                    score  + "/5", Toast.LENGTH_SHORT).show();
            setContentView(question5);
            return;
        }

    }

    public void submitQuestion5(View view) {
        question5Answer = findViewById(R.id.question_5a);
        boolean selectQuestion5Answer = question5Answer.isChecked();
        if (selectQuestion5Answer) {
            score += 1;
            Toast.makeText(this, "You received 1 bullet. Total bullets received so far: " +
                    score  + "/5", Toast.LENGTH_SHORT).show();
            setContentView(quizResults);
            viewResults(score);
            return;
        }
        else {
            Toast.makeText(this, "You received 0 bullets. Total bullets received so far: " +
                    score  + "/5", Toast.LENGTH_SHORT).show();
            setContentView(quizResults);
            viewResults(score);
            return;
        }
    }

    public void viewResults(int totalScore) {
        ImageView quizResultsImage = findViewById(R.id.quiz_results_image);
        Drawable civilian = getResources().getDrawable(R.drawable.civilian);
        Drawable usaf = getResources().getDrawable(R.drawable.usaf);
        Drawable usa = getResources().getDrawable(R.drawable.usa);
        Drawable usn = getResources().getDrawable(R.drawable.usn);
        Drawable usmc = getResources().getDrawable(R.drawable.usmc);
        TextView quizResults = findViewById(R.id.quiz_results);
        if (totalScore == 1) {
            quizResultsImage.setImageDrawable(civilian);
            quizResults.setText("You must be a civilian! \n \n Total Score: " + score + "/5");
        }
        else if (totalScore == 2) {
            quizResultsImage.setImageDrawable(usaf);
            quizResults.setText("You must be in the Air Force! \n \n Total Score: " + score + "/5");
        }
        else if (totalScore == 3) {
            quizResultsImage.setImageDrawable(usa);
            quizResults.setText("You must be in the Army! \n \n Total Score: " + score + "/5");
        }
        else if (totalScore == 4) {
            quizResultsImage.setImageDrawable(usn);
            quizResults.setText("You must be in the Navy! \n \n Total Score: " + score + "/5");
        }
        else if (totalScore == 5) {
            quizResultsImage.setImageDrawable(usmc);
            quizResults.setText("You must be in the Marine Corps! \n \n Oohrah and Semper Fidelis! \n \n Total Score: " + score + "/5");
        }
        else {
            quizResults.setText("Something went wrong!");
        }


    }
}
