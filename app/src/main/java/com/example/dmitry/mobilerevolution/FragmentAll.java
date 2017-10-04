package com.example.dmitry.mobilerevolution;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 04.10.2017.
 */

public class FragmentAll extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.land_fragment,container, false);
        Fragment fr = new FragmentRecyclerView();
        ElementFragment fr3=new ElementFragment();
        getFragmentManager().beginTransaction().add(R.id.fragment_container, fr).commit();
        getFragmentManager().beginTransaction().add(R.id.fragment_container1, fr3).commit();
        return viewGroup;
    }
}
