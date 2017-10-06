package com.example.dmitry.mobilerevolution;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 04.10.2017.
 */

public class ElementFragment extends Fragment {

    // Опять же не стоит делать статические ссылки на View
    private static TextView nameOfProduct;
    private static ImageView image;
    private static TextView description;
    private static String name="nameOfProduct";
    private static String descriptionOfProduct="descriptionOfProduct";
    private static String imageOfProduct="imageOfProduct";

    public static Fragment createStartFragment(String nameOfProduct, String description, Bitmap image){
        Fragment elementFragment = new ElementFragment();
        Bundle extras = new Bundle();
        extras.putString(name, nameOfProduct);
        extras.putString(descriptionOfProduct, description);
        extras.putParcelable(imageOfProduct, image);
        elementFragment.setArguments(extras);
        return elementFragment;
    }

    public void beforeStart(Bundle extras){
        if (extras!= null) {
            Parcelable imageProduct=extras.getParcelable(imageOfProduct);

            // if лучше всегда обрамлять в скобки, даже если в нем одна строка
            if(imageProduct!=null)
                image.setImageBitmap((Bitmap)imageProduct );
            else
                image.setImageResource(R.drawable.bread);
            nameOfProduct.setText(extras.getString(name));
            description.setText(extras.getString(descriptionOfProduct));
        }
    }
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
        beforeStart(bundle);
        return viewGroup;
    }
}