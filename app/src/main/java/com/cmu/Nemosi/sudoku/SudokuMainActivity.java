package com.cmu.Nemosi.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cmu.Nemosi.R;

public class SudokuMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_main);

        final Button easy = findViewById(R.id.easy);
        easy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                Intent i = new Intent(getApplicationContext(), SudokuGameActivity.class);
                i.putExtra("difficulty", 0);
                startActivity(i);
            }
        });

        final Button medium = findViewById(R.id.medium);
        medium.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                Intent i = new Intent(getApplicationContext(), SudokuGameActivity.class);
                i.putExtra("difficulty", 1);
                startActivity(i);
            }
        });

        final Button hard = findViewById(R.id.hard);
        hard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                Intent i = new Intent(getApplicationContext(), SudokuGameActivity.class);
                i.putExtra("difficulty", 2);
                startActivity(i);
            }
        });
    }
}
