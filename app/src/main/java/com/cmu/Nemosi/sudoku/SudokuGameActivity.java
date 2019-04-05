package com.cmu.Nemosi.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.cmu.Nemosi.R;
import com.example.sudoku_lib.*;

import java.util.ArrayList;

public class SudokuGameActivity extends AppCompatActivity {

    private GridView gameGridView;
    private GridViewAdapter gameAdapter;
    private ArrayList<ImageItem> gameList;
    private Grid gameGrid;
    private static int GRID_SIZE = 9;

    private ArrayList<Grid.Cell> numGrid;
    private ArrayList<ImageItem> numList;
    private GridViewAdapter numAdapter;
    private GridView numGridView;

    private SelectionInfo prevSelection;

    private class SelectionInfo {
        Grid.Cell cell;
        int position;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_game);
        Bundle b = getIntent().getExtras();
        int difficulty = b.getInt("difficulty");

        gameGridView = (GridView) findViewById(R.id.gameBoard);
        numGridView = (GridView) findViewById(R.id.numBoard);
        prevSelection = new SelectionInfo();
        prevSelection.cell = null;
        /* difficulty levels:
            0: easy - 35 empty cells
            1: medium - 45 empty cells
            2: hard - 55 empty cells
         */
        int numEmptyCells;
        switch (difficulty) {
            case 0:
                numEmptyCells = 35;
                break;
            case 1:
                numEmptyCells = 45;
                break;
            default:
                numEmptyCells = 55;
        }


        Generator generator = new Generator();
        gameGrid = generator.generate(numEmptyCells);
        gameList = loadGame(gameGrid);
        gameAdapter = new GridViewAdapter(this,
                R.layout.grid_cell_layout, gameList);
        gameGridView.setAdapter(gameAdapter);

        gameGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Grid.Cell cell = gameGrid.getCell(position / GRID_SIZE, position % GRID_SIZE);
                if (prevSelection.cell != null)
                    updateCellHighlight(prevSelection.cell, prevSelection.position, false);
                if (!cell.isInitialVal()) {
                    updateCellHighlight(cell, position, true);
                    prevSelection.cell = cell;
                    prevSelection.position = position;
                }
                else
                    prevSelection.cell = null;
                Toast.makeText(getApplicationContext(),"pressed "+cell.getValue(), Toast.LENGTH_SHORT).show();
            }
        });

        numGrid = createNumGrid();
        numList = loadNumImg(numGrid);
        numAdapter = new GridViewAdapter(this,
                R.layout.grid_cell_layout, numList);
        numGridView.setAdapter(numAdapter);

        numGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Grid.Cell cell = numGrid.get(position);
                if (prevSelection.cell != null) {
                    prevSelection.cell.setValue(cell.getValue());
                    updateCellHighlight(prevSelection.cell, prevSelection.position, false);
                    prevSelection.cell = null;
                }
                Toast.makeText(getApplicationContext(),"pressed "+cell.getValue(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateCellHighlight(Grid.Cell cell, int position, boolean hilight) {
        cell.setHighlighted(hilight);
        gameList.set(position, new ImageItem(getResources().getDrawable((findImageID(cell)))));
        gameAdapter.notifyDataSetChanged();
    }

    private ArrayList<ImageItem> loadGame(Grid grid) {
        ArrayList<ImageItem> content = new ArrayList<>();
        int id;
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                Grid.Cell cell = grid.getCell(row, column);
                content.add(new ImageItem(getResources().getDrawable(findImageID(cell))));
            }
        }
        return content;
    }

    private ArrayList<Grid.Cell> createNumGrid() {
        ArrayList<Grid.Cell> grid = new ArrayList<>();
        for (int i = 0; i < GRID_SIZE; i++) {
            grid.add(new Grid.Cell(i+1, false));
        }
        return grid;
    }

    private ArrayList<ImageItem> loadNumImg(ArrayList<Grid.Cell> grid) {
        ArrayList<ImageItem> lst = new ArrayList<>();
        for (int i = 0; i < GRID_SIZE; i++) {
            Drawable d = getResources().getDrawable(findImageID(grid.get(i)));
            lst.add(new ImageItem(d));
        }
        return lst;
    }

    private int findImageID(Grid.Cell cell) {
        int id;
        int val = cell.getValue();
        switch (val) {
            case 0:
                id = cell.isHighlighted() ? R.drawable.sel0 : R.drawable.fill0;
                break;
            case 1:
                if (cell.isInitialVal())
                    id = R.drawable.fixed1;
                else
                    id = cell.isHighlighted() ? R.drawable.sel1 : R.drawable.fill1;
                break;
            case 2:
                if (cell.isInitialVal())
                    id = R.drawable.fixed2;
                else
                    id = cell.isHighlighted() ? R.drawable.sel2 : R.drawable.fill2;
                break;
            case 3:
                if (cell.isInitialVal())
                    id = R.drawable.fixed3;
                else
                    id = cell.isHighlighted() ? R.drawable.sel3 : R.drawable.fill3;
                break;
            case 4:
                if (cell.isInitialVal())
                    id = R.drawable.fixed4;
                else
                    id = cell.isHighlighted() ? R.drawable.sel4 : R.drawable.fill4;
                break;
            case 5:
                if (cell.isInitialVal())
                    id = R.drawable.fixed5;
                else
                    id = cell.isHighlighted() ? R.drawable.sel5 : R.drawable.fill5;
                break;
            case 6:
                if (cell.isInitialVal())
                    id = R.drawable.fixed6;
                else
                    id = cell.isHighlighted() ? R.drawable.sel6 : R.drawable.fill6;
                break;
            case 7:
                if (cell.isInitialVal())
                    id = R.drawable.fixed7;
                else
                    id = cell.isHighlighted() ? R.drawable.sel7 : R.drawable.fill7;
                break;
            case 8:
                if (cell.isInitialVal())
                    id = R.drawable.fixed8;
                else
                    id = cell.isHighlighted() ? R.drawable.sel8 : R.drawable.fill8;
                break;
            default:
                if (cell.isInitialVal())
                    id = R.drawable.fixed9;
                else
                    id = cell.isHighlighted() ? R.drawable.sel9 : R.drawable.fill9;
        }
        return id;
    }
}
