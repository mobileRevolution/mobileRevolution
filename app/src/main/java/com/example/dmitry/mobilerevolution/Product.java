package com.example.dmitry.mobilerevolution;

import android.graphics.drawable.Drawable;

/**
 * Created by dmitry on 30.09.17.
 */

public class Product {

    private String name;
    /* Забыл указать, что в DAO-классе лучше хранить идентификатор изображения*/
    private Drawable photo;
    private String description;

    // Пустой конструктор не нужен
    public Product(){

    }

    /**
     * Необходимо форматировать код, в идеале в соответствии с Java CodeStyle и Android CodeStyle
     * https://github.com/ribot/android-guidelines/blob/master/project_and_code_guidelines.md
     * http://www.oracle.com/technetwork/java/codeconvtoc-136057.html -- читать его полностью
     * не обязательно, но нужно иметь ввиду.
     * К тому же, можно использовать комбинацию Ctrl + Alt + L для форматирования.
     */
    public Product(String name, Drawable photo, String description)
    {
        // сеттеры не стоит использовать в конструкторе
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
