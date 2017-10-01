package com.example.dmitry.mobilerevolution;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.Image;

/**
 * Created by dmitry on 30.09.17.
 */

public class Product {

    private String name;
    private Image photo;
    private String description;

    public Product(){

    }

    public Product(String name, Image photo,String description)
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

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
