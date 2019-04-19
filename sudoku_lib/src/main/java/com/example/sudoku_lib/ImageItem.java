package com.example.sudoku_lib;

import android.graphics.drawable.Drawable;

public class ImageItem {
    private Drawable image;

    public ImageItem(Drawable image) {
        super();
        this.image = image;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

}
