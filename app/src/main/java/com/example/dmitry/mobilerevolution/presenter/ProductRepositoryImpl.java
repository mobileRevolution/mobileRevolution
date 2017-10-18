package com.example.dmitry.mobilerevolution.presenter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.example.dmitry.mobilerevolution.view.adapters.AdapterRecycleView;
import com.example.dmitry.mobilerevolution.view.activities.ElementActivity;
import com.example.dmitry.mobilerevolution.view.fragments.ElementFragment;
import com.example.dmitry.mobilerevolution.R;
import com.example.dmitry.mobilerevolution.model.Product;
import com.example.dmitry.mobilerevolution.presenter.interfaces.ModelProductStub;
import com.example.dmitry.mobilerevolution.presenter.interfaces.ProductRepository;
import com.example.dmitry.mobilerevolution.view.interfaces.ViewAdapter;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by user on 06.10.2017.
 */

public class ProductRepositoryImpl implements ProductRepository {
    private ModelProductStub modelProductStub;
    private ViewAdapter adapter;
    private FragmentManager fragmentManager;

    public void setFragmentManager(FragmentManager manager) {
        this.fragmentManager = manager;
    }

    public ProductRepositoryImpl(Context context, ViewAdapter adapter) {
        modelProductStub = new ModelProductStubImpl(context);
        this.adapter = adapter;
    }

    @Override
    public void initProduct(AdapterRecycleView.ViewHolder holder, int position) {
        modelProductStub.getProducts().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        products->{
                            holder.init(products.get(position));
                        }
                );

    }

    public int getSizeOfProducts() {
      return modelProductStub.getProductsSize();
    }

    @Override
    public void initWithProduct(AdapterRecycleView.ViewHolder holder, View view) {
        holder.getPhotoProduct().buildDrawingCache();
        Bitmap photo = holder.getPhotoProduct().getDrawingCache();
        Bitmap watermarkimage = photo.copy(photo.getConfig(), true);

        if (view.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Intent intent = ElementActivity.createStartIntent(view.getContext(), holder.getNameOfProduct().getText().toString(), holder.getDescription(), watermarkimage);
            view.getContext().startActivity(intent);//тут будет вызываться новое активитии с подробной информацией
        } else {
            Fragment elementFragment = ElementFragment.createStartFragment(holder.getNameOfProduct().getText().toString(), holder.getDescription(), watermarkimage);
            fragmentManager.beginTransaction().replace(R.id.fragment_container1, elementFragment).commit();
        }
    }

    public void initWithStartProduct() {
        modelProductStub.getProducts().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        products->{
                            adapter.addFragment(products.get(0));
                        }
                );

    }


}
