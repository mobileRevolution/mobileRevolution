package com.example.dmitry.mobilerevolution.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dmitry.mobilerevolution.R;

/**
 * Created by user on 01.10.2017.
 */

public class ElementActivity  extends AppCompatActivity {
    /*private static final String BUNDLE_ID = "bundle_id";*/

    private static TextView nameOfProduct;
    private static ImageView image;
    private static TextView description;
    private static String name="nameOfProduct";
    private static String descriptionOfProduct="descriptionOfProduct";
    private static String imageOfProduct="imageOfProduct";

    public static Intent createStartIntent(Context context, String nameOfProduct, String description, Bitmap image) {
        Intent intent = new Intent(context, ElementActivity.class);
        intent.putExtra(ElementActivity.name, nameOfProduct);
        intent.putExtra(ElementActivity.descriptionOfProduct,description);
        intent.putExtra(ElementActivity.imageOfProduct,image);
        return intent;
    }

    public void beforeStart(Bundle extras){
        nameOfProduct.setText(extras.getString(name));
        description.setText(extras.getString(descriptionOfProduct));
        image.setImageBitmap((Bitmap)extras.getParcelable(imageOfProduct));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_element);
        nameOfProduct=(TextView) findViewById(R.id.elementName);
        image=(ImageView) findViewById(R.id.elementPhoto);
        description=(TextView) findViewById(R.id.elementDescription);

        Bundle extras = getIntent().getExtras();

        // Этот код выносится в отдельный метод, названия полей задаются константами
        beforeStart(extras);

    }

}
