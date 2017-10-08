package com.example.dmitry.mobilerevolution.view.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dmitry.mobilerevolution.R;
import com.example.dmitry.mobilerevolution.view.IntentBundleFields;

/**
 * Created by user on 01.10.2017.
 */

public class ElementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_element);
        IntentBundleFields.nameOfProduct = (TextView) findViewById(R.id.elementName);
        IntentBundleFields.image = (ImageView) findViewById(R.id.elementPhoto);
        IntentBundleFields.description = (TextView) findViewById(R.id.elementDescription);

        Bundle extras = getIntent().getExtras();
        // Этот код выносится в отдельный метод, названия полей задаются константами
        beforeStart(extras);
    }

    public static Intent createStartIntent(Context context, String nameOfProduct, String description, Bitmap image) {
        Intent intent = new Intent(context, ElementActivity.class);
        intent.putExtra(IntentBundleFields.name, nameOfProduct);
        intent.putExtra(IntentBundleFields.descriptionOfProduct, description);
        intent.putExtra(IntentBundleFields.imageOfProduct, image);
        return intent;
    }

    public void beforeStart(Bundle extras) {
        IntentBundleFields.nameOfProduct.setText(extras.getString(IntentBundleFields.name));
        IntentBundleFields.description.setText(extras.getString(IntentBundleFields.descriptionOfProduct));
        IntentBundleFields.image.setImageBitmap((Bitmap) extras.getParcelable(IntentBundleFields.imageOfProduct));
    }

}
