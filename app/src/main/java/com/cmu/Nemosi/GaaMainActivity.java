package com.cmu.Nemosi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cmu.Nemosi.stepsOrdering.StepsOrdering;
import com.cmu.Nemosi.sudoku.SudokuMainActivity;

public class GaaMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaa_main);

        final Button sudoku = findViewById(R.id.sudokuMain);
        sudoku.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent i = new Intent(getApplicationContext(), SudokuMainActivity.class);
                startActivity(i);
            }
        });

        final Button procMem =  findViewById(R.id.proceduralMemory);
        procMem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), StepsOrdering.class);
                startActivity(i);
            }
        });

    }
}
