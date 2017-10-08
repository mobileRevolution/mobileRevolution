package com.example.dmitry.mobilerevolution.presenter.interfaces;

import android.support.v4.app.FragmentManager;
import android.view.View;

import com.example.dmitry.mobilerevolution.view.adapters.AdapterRecycleView;

/**
 * Created by user on 06.10.2017.
 */

public interface ProductRepository {
    void initProduct(AdapterRecycleView.ViewHolder holder,int position);
    int getSizeOfProducts();
    void initWithProduct(AdapterRecycleView.ViewHolder holder,View view);
    void initWithStartProduct();
    void setFragmentManager(FragmentManager manager);
}
