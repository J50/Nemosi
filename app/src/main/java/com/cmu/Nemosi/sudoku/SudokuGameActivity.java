package com.cmu.Nemosi.sudoku;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.cmu.Nemosi.R;
import com.example.sudoku_lib.*;

import java.util.ArrayList;

public class SudokuGameActivity extends AppCompatActivity {

    private GridView gameGrid;
    private ArrayAdapter<String> gameAdapter;
    private ArrayList<String> gameContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_game);
        Bundle b = getIntent().getExtras();
        int difficulty = b.getInt("difficulty");

        gameGrid = (GridView) findViewById(R.id.gameBoard);

        /* difficulty levels:
            0: easy - 25 empty cells
            1: medium - 35 empty cells
            2: hard - 45 empty cells
         */
        int numEmptyCells;
        switch (difficulty) {
            case 0:
                numEmptyCells = 25;
                break;
            case 1:
                numEmptyCells = 35;
                break;
            default:
                numEmptyCells = 45;
        }

        Generator generator = new Generator();
        Grid grid = generator.generate(numEmptyCells);
        gameContent = readContent(grid);

        gameAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, gameContent);
        gameGrid.setAdapter(gameAdapter);
    }


    private ArrayList<String> readContent(Grid grid) {
        ArrayList<String> content = new ArrayList<String>();
        int size = grid.getSize();
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                Grid.Cell cell = grid.getCell(row, column);
                int val = cell.getValue();
                if (val != 0)
                    content.add(String.valueOf(val));
                else
                    content.add(new String(" "));
            }
        }
        return content;
    }
}
