package com.example.dmitry.mobilerevolution;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by dmitry on 30.09.17.
 */

public class Product {

    private String name;
    private Drawable photo;
    private String description;

    public Product(){

    }

    public Product(String name, Drawable photo, String description)
    {
        setName(name);
        setPhoto(photo);
        setDescription(description);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
