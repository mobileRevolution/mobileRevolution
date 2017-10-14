package com.example.dmitry.mobilerevolution.presenter.interfaces;

import com.example.dmitry.mobilerevolution.model.Product;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by user on 06.10.2017.
 */

public interface ModelProductStub {
    Observable<List<Product>> getProducts();
    int getProductsSize();

}
