package com.example.dmitry.mobilerevolution;

import android.graphics.Bitmap;

/**
 * Created by dmitry on 30.09.17.
 */

public class Product {

    private String name;
    private Bitmap photoBitmap;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getPhotoBitmap() {
        return photoBitmap;
    }

    public void setPhotoBitmap(Bitmap photoBitmap) {
        this.photoBitmap = photoBitmap;
    }
}
