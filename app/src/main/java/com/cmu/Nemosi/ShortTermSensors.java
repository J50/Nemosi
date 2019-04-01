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


                String command = "ask Tile to find my keys";
//                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                Intent intent = new Intent(Intent.ACTION_VOICE_COMMAND);
//                intent.setClassName("com.google.android.googlequicksearchbox", "com.google.android.googlequicksearchbox.SearchActivity");
                intent.putExtra("query", command);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //necessary if launching from Service
                startActivity(intent);


            }
        });

        final Button button_test = findViewById(R.id.button_test);
        button_test.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                Intent i = new Intent(getApplicationContext(), DailyTest.class);
                startActivity(i);
            }
        });
    }
}
