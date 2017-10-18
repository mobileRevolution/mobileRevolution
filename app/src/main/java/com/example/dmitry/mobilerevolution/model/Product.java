package com.example.dmitry.mobilerevolution.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by dmitry on 30.09.17.
 */

public class Product {

    private String name;
    private String photo;
    private String description;


    public Product(String name, String photo, String description) {
        this.name = name;
        this.photo = photo;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
