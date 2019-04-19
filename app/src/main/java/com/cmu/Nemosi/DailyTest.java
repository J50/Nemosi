package com.cmu.Nemosi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DailyTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_test);

//        TextView myTextView = findViewById(R.id.myTextView);
//        myTextView.setText("Welcome to Daily Check-in");

        // initialize arrays for each question-input
        ArrayList<Spinner> spinners = new ArrayList<Spinner>();
        ArrayList<TextView> questions = new ArrayList<TextView>();
        ArrayList<LinearLayout> layouts = new ArrayList<LinearLayout>();
        ArrayList<String> question_strings = new ArrayList<String>();

        // set each layout for each question-input
        LinearLayout bigLayout = findViewById(R.id.bigLayout);
        for (int i = 0; i <= 12; i++) {
            questions.add(new TextView(this));
            spinners.add(new Spinner(this));
            layouts.add(new LinearLayout(this));
            layouts.get(i).addView(questions.get(i));
            layouts.get(i).addView(spinners.get(i));
            layouts.get(i).setOrientation(LinearLayout.HORIZONTAL);
            bigLayout.addView(layouts.get(i));
        }

        // first question
        questions.get(0).setText("Sleeping more than usual?");
        questions.get(1).setText("Balance problems/dizziness?");
        questions.get(2).setText("Difficulty remembering?");
        questions.get(3).setText("Difficulty concentrating?");
        questions.get(4).setText("Memory problems?");
        questions.get(5).setText("Nervousness?");
        questions.get(6).setText("Drowsiness?");
        questions.get(7).setText("Do you have more trouble remembering things that have happened recently than you used to?");
        questions.get(8).setText("Do you have more trouble recalling conversations a few days later?");
        questions.get(9).setText("When speaking, do you have more difficulty in finding the right word or tend to use the wrong words more often?");
        questions.get(10).setText("Are you less able to manage money and financial affairs (e.g. paying bills, budgeting)?");
        questions.get(11).setText("Are you less able to manage your medication independently?");
        questions.get(12).setText("Do you need more assistance with transport (either private or public), not due to physical problems?");

        List<String> severity = new ArrayList<String>(4);
        severity.add("Not good");
        severity.add("Moderate");
        severity.add("Good");
        severity.add("Excellent");
        ArrayAdapter<String> firstAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, severity);
        firstAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        List<String> yesNo = new ArrayList<String>(4);
        yesNo.add("Yes");
        yesNo.add("No");
        ArrayAdapter<String> secondAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, severity);
        secondAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinners.get(0).setAdapter(firstAdapter);
        spinners.get(1).setAdapter(firstAdapter);
        spinners.get(2).setAdapter(firstAdapter);
        spinners.get(3).setAdapter(firstAdapter);
        spinners.get(4).setAdapter(firstAdapter);
        spinners.get(5).setAdapter(firstAdapter);
        spinners.get(6).setAdapter(firstAdapter);
        spinners.get(7).setAdapter(firstAdapter);
        spinners.get(8).setAdapter(firstAdapter);
        spinners.get(9).setAdapter(secondAdapter);
        spinners.get(10).setAdapter(secondAdapter);
        spinners.get(11).setAdapter(secondAdapter);
        spinners.get(12).setAdapter(secondAdapter);


    }
}
