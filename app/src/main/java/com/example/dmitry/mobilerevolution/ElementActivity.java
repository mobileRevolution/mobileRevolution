package com.example.dmitry.mobilerevolution;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * Created by user on 01.10.2017.
 */

public class ElementActivity  extends AppCompatActivity {
    /*private static final String BUNDLE_ID = "bundle_id";*/

    private TextView nameOfProduct;
    private ImageView image;
    private TextView description;

    /*public static Intent createStartIntent(Context context, String id) {
        Intent intent = new Intent(context, ElementActivity.class);
        intent.putExtra(BUNDLE_ID, id);
        return intent;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_element);
        nameOfProduct=(TextView) findViewById(R.id.elementName);
        image=(ImageView) findViewById(R.id.elementPhoto);
        description=(TextView) findViewById(R.id.elementDescription);

        Bundle extras = getIntent().getExtras();

        // Этот код выносится в отдельный метод, названия полей задаются константами
        image.setImageBitmap((Bitmap) extras.getParcelable("photoOfProduct"));
        nameOfProduct.setText(extras.getString("nameOfProduct"));
        description.setText(extras.getString("descriptionOfProduct"));

    }

}
