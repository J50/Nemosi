package com.cmu.Nemosi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.pm.PackageManager;

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

                Intent intent = getPackageManager().getLaunchIntentForPackage("com.thetileapp.tile");
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

        final Button button_flicSetup = findViewById(R.id.button_flicSetup);
        button_flicSetup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), FlicButtonSetup.class);
                startActivity(i);

            }
        });
    }
}
