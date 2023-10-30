package com.bdmariobd.mercadonafc.api;

import com.bdmariobd.mercadonafc.models.Categories;
import com.bdmariobd.mercadonafc.models.CategoryProducts;
import com.bdmariobd.mercadonafc.models.PriceDrops;
import com.bdmariobd.mercadonafc.models.Product;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MercadonaAPIService {

    @GET("products/{product_id}")
    Call<Product> getProductById(@Path("product_id") String productId);

    @GET("categories/")
    Call<Categories> getCategories();

    @GET("categories/{category_id}")
    Call<CategoryProducts> getCategoryById(@Path("category_id") String categoryId);

    @GET("home/price-drops/")
    Call<PriceDrops> getPriceDrops();

    @GET("home/new-arrivals/")
    Call<PriceDrops> getNewArrivals();

}
