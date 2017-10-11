package com.example.dmitry.mobilerevolution.view;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dmitry on 08.10.17.
 */

public class IntentBundleFields {
    public static TextView nameOfProduct; // нельзя делать статические ссылки на View, это должно быть в рамках класс View
    public static ImageView image;
    public static TextView description;


    final public static String name="nameOfProduct";
    final public static String descriptionOfProduct="descriptionOfProduct";
    final public static String imageOfProduct="imageOfProduct";
}
