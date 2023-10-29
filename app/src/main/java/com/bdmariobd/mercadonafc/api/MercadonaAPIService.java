package com.bdmariobd.mercadonafc.api;

import com.bdmariobd.mercadonafc.models.Product;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MercadonaAPIService {

    @GET("products/{product_id}")
    Call<Product> getProductById(@Path("product_id") String productId);

}
