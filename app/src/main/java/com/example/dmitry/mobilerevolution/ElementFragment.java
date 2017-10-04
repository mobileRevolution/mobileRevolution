package com.example.dmitry.mobilerevolution;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 04.10.2017.
 */

public class ElementFragment extends Fragment {

    private static TextView nameOfProduct;
    private static ImageView image;
    private static TextView description;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.information_element, container, false);
        nameOfProduct = (TextView) viewGroup.findViewById(R.id.elementName);
        image = (ImageView) viewGroup.findViewById(R.id.elementPhoto);
        description = (TextView) viewGroup.findViewById(R.id.elementDescription);
        Bundle bundle = getArguments();
        if (bundle != null) {

            if(bundle.getParcelable("photoOfProduct")!=null)
            image.setImageBitmap((Bitmap) bundle.getParcelable("photoOfProduct"));
            else
                image.setImageResource(R.drawable.bread);
            nameOfProduct.setText(bundle.getString("nameOfProduct"));
            description.setText(bundle.getString("descriptionOfProduct"));
        }
        return viewGroup;
    }
}