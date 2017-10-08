package com.example.dmitry.mobilerevolution.view.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.dmitry.mobilerevolution.R;
import com.example.dmitry.mobilerevolution.view.adapters.AdapterRecycleView;


/**
 * Created by dmitry on 01.10.17.
 */

public class FragmentRecyclerView extends Fragment {

    // должен быть модификатор private
    public FragmentRecyclerView()
    {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //привязываю RecycleView к фрагменту
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_recycleview,container, false);
        RecyclerView rv = viewGroup.findViewById(R.id.fragmentRecyclerView);
        if(getActivity().getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            Fragment f=new ElementFragment();
            this.getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment_container1,f);
        }
        //привязываю адаптер для RecycleView
        AdapterRecycleView adapter = new AdapterRecycleView(getContext());
        adapter.setManager(this.getActivity().getSupportFragmentManager());
        rv.setAdapter(adapter);
        return viewGroup;
    }


    //временное заполнение тестовыми данными список продуктов

}
