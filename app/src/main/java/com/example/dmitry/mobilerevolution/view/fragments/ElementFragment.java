package com.example.dmitry.mobilerevolution.view.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dmitry.mobilerevolution.R;
import com.example.dmitry.mobilerevolution.view.IntentBundleFields;

/**
 * Created by user on 04.10.2017.
 */

public class ElementFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.information_element, container, false);

        IntentBundleFields.nameOfProduct = viewGroup.findViewById(R.id.elementName);
        IntentBundleFields.image = viewGroup.findViewById(R.id.elementPhoto);
        IntentBundleFields.description = viewGroup.findViewById(R.id.elementDescription);

        Bundle bundle = getArguments();
        beforeStart(bundle);

        return viewGroup;
    }

    public static Fragment createStartFragment(String nameOfProduct, String description, Bitmap image) {
        Fragment elementFragment = new ElementFragment();
        Bundle extras = new Bundle();
        extras.putString(IntentBundleFields.name, nameOfProduct);
        extras.putString(IntentBundleFields.descriptionOfProduct, description);
        extras.putParcelable(IntentBundleFields.imageOfProduct, image);
        elementFragment.setArguments(extras);
        return elementFragment;
    }

    public void beforeStart(Bundle extras) {

        if (extras != null) {
            Parcelable imageProduct = extras.getParcelable(IntentBundleFields.imageOfProduct);

            if (imageProduct != null)
                IntentBundleFields.image.setImageBitmap((Bitmap) imageProduct);
            else
                IntentBundleFields.image.setImageResource(R.drawable.bread);
            IntentBundleFields.nameOfProduct.setText(extras.getString(IntentBundleFields.name));
            IntentBundleFields.description.setText(extras.getString(IntentBundleFields.descriptionOfProduct));
        }
    }

}