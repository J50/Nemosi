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
        for (int i = 0; i < 10; i++) {
            questions.add(new TextView(this));
            spinners.add(new Spinner(this));
            layouts.add(new LinearLayout(this));
            layouts.get(i).addView(spinners.get(i));
            layouts.get(i).addView(questions.get(i));
            layouts.get(i).setOrientation(LinearLayout.HORIZONTAL);
            bigLayout.addView(layouts.get(i));
        }

        // first question
        questions.get(0).setText("How are you feeling?");
        List<String> severity = new ArrayList<String>(4);
        severity.add("Not good");
        severity.add("Moderate");
        severity.add("Good");
        severity.add("Excellent");
        ArrayAdapter<String> firstAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, severity);
        firstAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinners.get(0).setAdapter(firstAdapter);

    }
}
