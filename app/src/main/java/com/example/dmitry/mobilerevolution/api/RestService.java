package com.example.dmitry.mobilerevolution.api;


import com.example.dmitry.mobilerevolution.model.Product;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by dmitry on 14.10.17.
 */

public interface RestService {

    String BASE_URL = "https://android-cources.simbirsoft1.com/api/";

    // отсутсвуют данные на сервере Оо

    @Headers({"Authorization: Basic NTlkZGI5ZmZhNGJlMjA1ODZkMjYwZWEyOiBhMDUzMTMxN2Jk",
            "X-Api-Factory-Application-Id: 59ddb9ffa4be20586d260ea2",
            "Content-Type: application/json"})
    @GET("db/product")
    Observable<BaseResponse<List<Product>>> getProducts();

}
