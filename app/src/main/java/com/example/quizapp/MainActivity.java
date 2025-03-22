package com.example.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button no;
    TextView textView2;
    Button reset;
    private String[] questions = {"Is Java created by James Gosling?", "Is Java developed in 1994?",
            "Is java not a Enterprise Language?", "Does Java have interface?", "Java has abstraction??"};
    private Boolean[] answers = {true, false, false, true, true};
    private int index = 0;
    private int score = 0;
    public String[] getQuestions() {
        return questions;
    }

    public void setQuestions(String[] questions) {
        this.questions = questions;
    }

    public Boolean[] getAnswers() {
        return answers;
    }

    public void setAnswers(Boolean[] answers) {
        this.answers = answers;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        textView2 = findViewById(R.id.textView2);
        textView2.setText(questions[0]);

    }

    public void yes(View view)
    {
        Button yes = findViewById(R.id.yes);
        if(index <= questions.length -1 ) {
            if (answers[index])
                score++;
            index++;
            if (index <= questions.length - 1)
                textView2.setText(questions[index]);
            else
            {
                int score = getScore();
                Toast.makeText(this, "Your Score is " + score, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void no(View view)
    {
        if(index <= questions.length -1 )
        {
            if(!answers[index])
                score++;
            index++;
            if(index <= questions.length-1)
                textView2.setText(questions[index]);
            else
            {
                int score = getScore();
                Toast.makeText(this, "Your Score is " + score, Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void reset(View view)
    {
        reset = findViewById(R.id.reset);
            setIndex(0);
            setScore(0);
            textView2.setText(questions[index]);
    }
}
