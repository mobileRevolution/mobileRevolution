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

    private TextView nameOfProduct;
    private ImageView image;
    private TextView description;

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
            image.setImageBitmap((Bitmap) bundle.getParcelable("photoOfProduct"));
            nameOfProduct.setText(bundle.getString("nameOfProduct"));
            description.setText(bundle.getString("descriptionOfProduct"));
        } else {
            Product p = new Product("Bread", ContextCompat.getDrawable(getContext(),R.drawable.bread), "Bread is a staple food prepared from a dough of flour and water, usually by baking. Throughout recorded history it has been popular around the world and is one of the oldest artificial foods, having been of importance since the dawn of agriculture.\n" +
                    "\n" +
                    "Proportions of types of flour and other ingredients vary widely, as do modes of preparation. As a result, types, shapes, sizes, " +
                    "and textures of breads differ around the world. Bread may be leavened by processes such as reliance on naturally occurring sourdough " +
                    "microbes, chemicals, industrially produced yeast, or high-pressure aeration. Some bread is cooked before it can leaven, including for traditional or religious " +
                    "reasons. Non-cereal ingredients such as fruits, nuts and fats may be included." +
                    " Commercial bread commonly contains additives to improve flavor, " +
                    "texture, color, shelf life, and ease of manufacturing.");
            image.setImageDrawable(p.getPhoto());
            nameOfProduct.setText(p.getName());
            description.setText(p.getDescription());
        }
        return viewGroup;
    }
}