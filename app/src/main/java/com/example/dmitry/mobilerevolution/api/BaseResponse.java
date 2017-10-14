package com.example.dmitry.mobilerevolution.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dmitry on 14.10.17.
 */

public class BaseResponse<T> {

    @SerializedName("data")
    protected T data;

    public T getData() { return data; }
}
