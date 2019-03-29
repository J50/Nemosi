package com.cmu.Nemosi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


//this activity will contain work from the STM team. Eventually, this activity will be removed and sub activities will be launched from main

public class ShortTermSensors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_term_sensors);

        TextView myTextView = findViewById(R.id.myTextView2);
        myTextView.setText("This activity will contain content from the short term memory group.");

        final Button button = findViewById(R.id.button_findMyStuff);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //find my stuff button


                //manu start writing logic here

            }
        });
    }
}
