package com.example.dmitry.mobilerevolution.model;

import android.graphics.drawable.Drawable;

/**
 * Created by dmitry on 30.09.17.
 */

public class Product {

    private String name;
    /* Забыл указать, что в DAO-классе лучше хранить идентификатор изображения*/
    private Drawable photo;
    private String description;


    public Product(String name, Drawable photo, String description) {
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
