package com.example.sudoku_lib;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class SquareImageView extends ImageView {
    public SquareImageView (Context context) {
        super(context);
    }

    public SquareImageView (Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageView (Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    public SquareGridView (Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    @Override
    protected void onMeasure (int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
//        setMeasuredDimension(widthMeasureSpec, widthMeasureSpec);
    }
}

