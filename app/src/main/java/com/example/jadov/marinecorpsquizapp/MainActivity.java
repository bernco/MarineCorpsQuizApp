package com.example.jadov.marinecorpsquizapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    //declare variables
    private int score;
    private int question1, question2, question3, question4, question5, quizResults;
    private RelativeLayout quizResultsLayout;
    private CheckBox question1Answer1, question1Answer2, question4Answer1, question4Answer2, question4Answer3;
    private CheckBox question1Wrong1, question1Wrong2, question4Wrong1;
    private RadioButton question2Answer, question5Answer;
    private RadioButton question2Wrong1, question2Wrong2, question2Wrong3, question5Wrong1, question5Wrong2, question5Wrong3;
    private EditText name, question3Answer;
    private int main = R.layout.activity_main;
    private MediaPlayer mediaPlayer, marinesHymn;
    private Button bullet_send, bullet_restart;
    private String enterName = "", resultsMessage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(main);

        //set orientation to portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //call name view
        name = findViewById(R.id.name);

        //create media players for sound files
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.rifle_gun_shot);
        marinesHymn = MediaPlayer.create(MainActivity.this, R.raw.the_marines_hymn);

        //declare layout files
        main = R.layout.activity_main;
        question1 = R.layout.question_1;
        question2 = R.layout.question_2;
        question3 = R.layout.question_3;
        question4 = R.layout.question_4;
        question5 = R.layout.question_5;
        quizResults = R.layout.quiz_results;
    }

    // method for the main activity page and entering into the quiz
    public void startQuiz(View view) {
        enterName = name.getText().toString();
        if (enterName.equals(null) || enterName.equals("")) {
            Toast.makeText(this, "You didn't enter your name! Try again!", Toast.LENGTH_SHORT).show();
        } else {
            resultsMessage += "Name: " + enterName + "\n\n";
            setContentView(question1);
            mediaPlayer.start();
        }
    }

    // method for submitting answers for question 1 and going to question 2
    public void submitQuestion1(View view) {
        question1Wrong1 = findViewById(R.id.question_1a);
        question1Answer1 = findViewById(R.id.question_1b);
        question1Answer2 = findViewById(R.id.question_1c);
        question1Wrong2 = findViewById(R.id.question_1d);

        boolean selectQuestion1Wrong1 = question1Wrong1.isChecked();
        boolean selectQuestion1Answer1 = question1Answer1.isChecked();
        boolean selectQuestion1Answer2 = question1Answer2.isChecked();
        boolean selectQuestion1Wrong2 = question1Wrong2.isChecked();

        if (!selectQuestion1Wrong1 && !selectQuestion1Answer1 && !selectQuestion1Answer2 && !selectQuestion1Wrong2) {
            Toast.makeText(this, "You didn't make a selection! Try again!", Toast.LENGTH_SHORT).show();
        } else if (selectQuestion1Answer1 && selectQuestion1Answer2) {
            score += 25;
            resultsMessage += getString(R.string.quiz_results_question_1, getString(R.string.correct_answer_1) + "\n\n");
            Toast.makeText(this, "You received 25 bullets. Total bullets received so far: " +
                    score + "/100", Toast.LENGTH_SHORT).show();
            setContentView(question2);
            mediaPlayer.start();
            return;
        } else {
            resultsMessage += getString(R.string.quiz_results_question_1, getString(R.string.incorrect_answer) + "\n\n");
            Toast.makeText(this, "You received 0 bullets. Total bullets received so far: " +
                    score + "/100", Toast.LENGTH_SHORT).show();
            setContentView(question2);
            mediaPlayer.start();
            return;
        }
    }

    // method for submitting answer for question 2 and going to question 3
    public void submitQuestion2(View view) {
        question2Wrong1 = findViewById(R.id.question_2a);
        question2Wrong2 = findViewById(R.id.question_2b);
        question2Wrong3 = findViewById(R.id.question_2c);
        question2Answer = findViewById(R.id.question_2d);

        boolean selectQuestion2Wrong1 = question2Wrong1.isChecked();
        boolean selectQuestion2Wrong2 = question2Wrong2.isChecked();
        boolean selectQuestion2Wrong3 = question2Wrong3.isChecked();
        boolean selectQuestion2Answer = question2Answer.isChecked();

        if (!selectQuestion2Wrong1 && !selectQuestion2Wrong2 && !selectQuestion2Wrong3 && !selectQuestion2Answer) {
            Toast.makeText(this, "You didn't make a selection! Try again!", Toast.LENGTH_SHORT).show();
        } else if (selectQuestion2Answer) {
            score += 15;
            resultsMessage += getString(R.string.quiz_results_question_2, getString(R.string.correct_answer_2) + "\n\n");
            Toast.makeText(this, "You received 15 bullets. Total bullets received so far: " +
                    score + "/100", Toast.LENGTH_SHORT).show();
            setContentView(question3);
            mediaPlayer.start();
            return;
        } else {
            resultsMessage += getString(R.string.quiz_results_question_2, getString(R.string.incorrect_answer) + "\n\n");
            Toast.makeText(this, "You received 0 bullets. Total bullets received so far: " +
                    score + "/100", Toast.LENGTH_SHORT).show();
            setContentView(question3);
            mediaPlayer.start();
            return;
        }
    }

    // method for submitting answer for question 3 and going to question 4
    public void submitQuestion3(View view) {
        question3Answer = findViewById(R.id.question_3_answer);

        String enterQuestion3Answer = question3Answer.getText().toString();

        if (enterQuestion3Answer.equals(null) || enterQuestion3Answer.equals("")) {
            Toast.makeText(this, "You didn't enter any text! Try again!", Toast.LENGTH_SHORT).show();
        } else if (enterQuestion3Answer.equals("11/10/1775")) {
            score += 15;
            resultsMessage += getString(R.string.quiz_results_question_3, getString(R.string.correct_answer_3) + "\n\n");
            Toast.makeText(this, "You received 15 bullets. Total bullets received so far: " +
                    score + "/100", Toast.LENGTH_SHORT).show();
            setContentView(question4);
            mediaPlayer.start();
            return;
        } else {
            resultsMessage += getString(R.string.quiz_results_question_3, getString(R.string.incorrect_answer) + "\n\n");
            Toast.makeText(this, "You received 0 bullets. Total bullets received so far: " +
                    score + "/100", Toast.LENGTH_SHORT).show();
            setContentView(question4);
            mediaPlayer.start();
            return;
        }
    }

    // method for submitting answers for question 4 and going to question 5
    public void submitQuestion4(View view) {
        question4Answer1 = findViewById(R.id.question_4a);
        question4Wrong1 = findViewById(R.id.question_4b);
        question4Answer2 = findViewById(R.id.question_4c);
        question4Answer3 = findViewById(R.id.question_4d);

        boolean selectQuestion4Answer1 = question4Answer1.isChecked();
        boolean selectQuestion4Wrong1 = question4Wrong1.isChecked();
        boolean selectQuestion4Answer2 = question4Answer2.isChecked();
        boolean selectQuestion4Answer3 = question4Answer3.isChecked();

        if (!selectQuestion4Answer1 && !selectQuestion4Wrong1 && !selectQuestion4Answer2 && !selectQuestion4Answer3) {
            Toast.makeText(this, "You didn't make a selection! Try again!", Toast.LENGTH_SHORT).show();
        } else if (selectQuestion4Answer1 && selectQuestion4Answer2 && selectQuestion4Answer3) {
            score += 30;
            resultsMessage += getString(R.string.quiz_results_question_4, getString(R.string.correct_answer_4) + "\n\n");
            Toast.makeText(this, "You received 30 bullets. Total bullets received so far: " +
                    score + "/100", Toast.LENGTH_SHORT).show();
            setContentView(question5);
            mediaPlayer.start();
            return;
        } else {
            resultsMessage += getString(R.string.quiz_results_question_4, getString(R.string.incorrect_answer) + "\n\n");
            Toast.makeText(this, "You received 0 bullets. Total bullets received so far: " +
                    score + "/100", Toast.LENGTH_SHORT).show();
            setContentView(question5);
            mediaPlayer.start();
            return;
        }
    }

    // method for submitting answer for question 5 and going to the quiz results
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void submitQuestion5(View view) {
        question5Answer = findViewById(R.id.question_5a);
        question5Wrong1 = findViewById(R.id.question_5b);
        question5Wrong2 = findViewById(R.id.question_5c);
        question5Wrong3 = findViewById(R.id.question_5d);

        boolean selectQuestion5Answer = question5Answer.isChecked();
        boolean selectQuestion5Wrong1 = question5Wrong1.isChecked();
        boolean selectQuestion5Wrong2 = question5Wrong2.isChecked();
        boolean selectQuestion5Wrong3 = question5Wrong3.isChecked();

        if (!selectQuestion5Answer && !selectQuestion5Wrong1 && !selectQuestion5Wrong2 && !selectQuestion5Wrong3) {
            Toast.makeText(this, "You didn't make a selection! Try again!", Toast.LENGTH_SHORT).show();
        } else if (selectQuestion5Answer) {
            score += 15;
            resultsMessage += getString(R.string.quiz_results_question_5, getString(R.string.correct_answer_5) + "\n\n");
            Toast.makeText(this, "You received 15 bullets. Total bullets received so far: " +
                    score + "/100", Toast.LENGTH_SHORT).show();
            setContentView(quizResults);
            viewResults(score);
            return;

        } else {
            resultsMessage += getString(R.string.quiz_results_question_5, getString(R.string.incorrect_answer) + "\n\n");
            Toast.makeText(this, "You received 0 bullets. Total bullets received so far: " +
                    score + "/100", Toast.LENGTH_SHORT).show();
            setContentView(quizResults);
            viewResults(score);
            return;
        }
    }

    // method for viewing quiz results based on overall scores
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void viewResults(int totalScore) {
        ImageView quizResultsImage = findViewById(R.id.quiz_results_image);
        TextView quizResults = findViewById(R.id.quiz_results);
        quizResultsLayout = findViewById(R.id.quiz_results_page);
        bullet_send = findViewById(R.id.bullet_email);
        bullet_restart = findViewById(R.id.bullet_restart);

        Drawable civilian = getResources().getDrawable(R.drawable.civilian);
        Drawable usaf = getResources().getDrawable(R.drawable.usaf);
        Drawable usa = getResources().getDrawable(R.drawable.usa);
        Drawable usn = getResources().getDrawable(R.drawable.usn);
        Drawable usmc = getResources().getDrawable(R.drawable.usmc);

        if (totalScore == 0) {
            quizResults.setText(enterName + getString(R.string.killed_response_1) + score + getString(R.string.killed_response_2));
            quizResultsLayout.setBackgroundColor(Color.RED);
            bullet_send.setBackground(getResources().getDrawable(R.drawable.send_killed));
            bullet_restart.setBackground(getResources().getDrawable(R.drawable.restart_killed));
        } else if (totalScore > 0 && totalScore <= 25) {
            quizResultsImage.setImageDrawable(civilian);
            quizResults.setText(enterName + getString(R.string.civ_response) + score + "/100");
        } else if (totalScore > 25 && totalScore <= 50) {
            quizResultsImage.setImageDrawable(usaf);
            quizResults.setText(enterName + getString(R.string.usaf_response) + score + "/100");
        } else if (totalScore > 50 && totalScore <= 75) {
            quizResultsImage.setImageDrawable(usa);
            quizResults.setText(enterName + getString(R.string.usa_response) + score + "/100");
        } else if (totalScore > 75 && totalScore <= 99) {
            quizResultsImage.setImageDrawable(usn);
            quizResults.setText(enterName + getString(R.string.usn_response) + score + "/100");
        } else if (totalScore == 100) {
            marinesHymn.start();
            quizResultsImage.setImageDrawable(usmc);
            quizResults.setText(enterName + getString(R.string.usmc_response) + score + "/100");
        } else {
            quizResults.setText(enterName + getString(R.string.error_response));
        }

    }

    // method for sending the quiz results via email
    public void sendResults(View view) {
        String getName = name.getText().toString();
        int total = score;
        String subject = getString(R.string.quiz_results_email_subject, getName);
        String message = createResultsSummary(total);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    // method for creating the results summary message for the results email
    private String createResultsSummary(int score) {
        mediaPlayer.start();
        marinesHymn.release();
        this.score = score;
        TextView quizResults = findViewById(R.id.quiz_results);
        resultsMessage += quizResults.getText().toString();
        return resultsMessage;
    }

    // method for restarting the quiz application
    public void restart(View view) {
        mediaPlayer.start();
        marinesHymn.release();
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
