package com.bdmariobd.mercadonafc.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.bdmariobd.mercadonafc.R;
import com.bdmariobd.mercadonafc.api.MercadonaAPIService;
import com.bdmariobd.mercadonafc.models.Categories;
import com.bdmariobd.mercadonafc.models.CategoryProducts;
import com.bdmariobd.mercadonafc.models.Product;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchFragment extends Fragment {
    private MercadonaAPIService apiService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.api_base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(MercadonaAPIService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    public void getProductInfo(String productId) {
        Call<Product> call_async = apiService.getProductById(productId);
        call_async.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (response.isSuccessful()) {
                    Product product = response.body();
                    Log.i("MiW", "onResponse => " + product);
                } else {
                    Log.e("MiW", "onResponse => " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Log.i("MiW", "onFailure => " + t.getMessage());
            }
        });


    }

    public void getCategory(String categoryId) {
        Call<Categories> call_async = apiService.getCategories();
        call_async.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                if (response.isSuccessful()) {
                    Categories product = response.body();
                    Log.i("MiW", "onResponse => " + product);
                } else {
                    Log.e("MiW", "onResponse => " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                Log.i("MiW", "onFailure => " + t.getMessage());
            }
        });
    }

    public void getCategoryById(String categoryId) {
        Call<CategoryProducts> call_async = apiService.getCategoryById(categoryId);
        call_async.enqueue(new Callback<CategoryProducts>() {
            @Override
            public void onResponse(Call<CategoryProducts> call, Response<CategoryProducts> response) {
                if (response.isSuccessful()) {
                    CategoryProducts product = response.body();
                    Log.i("MiW", "onResponse => " + product);
                } else {
                    Log.e("MiW", "onResponse => " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<CategoryProducts> call, Throwable t) {
                Log.i("MiW", "onFailure => " + t.getMessage());
            }
        });
    }
}
