package com.bdmariobd.mercadonafc.fragments.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bdmariobd.mercadonafc.R;
import com.bdmariobd.mercadonafc.api.MercadonaAPIService;
import com.bdmariobd.mercadonafc.fragments.home.HomeAdapter;
import com.bdmariobd.mercadonafc.models.CategoryInternal;
import com.bdmariobd.mercadonafc.models.CategoryProducts;
import com.bdmariobd.mercadonafc.models.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductsByCategoryFragment extends Fragment {

    private final String categoryId;
    private MercadonaAPIService mercadonaAPIService;
    private HomeAdapter homeAdapter;

    public ProductsByCategoryFragment(String categoryId) {
        this.categoryId = categoryId;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.api_base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mercadonaAPIService = retrofit.create(MercadonaAPIService.class);
        homeAdapter = new HomeAdapter(new ArrayList<>());
        getProducts();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_products, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.rvSearchListProducts);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(homeAdapter);
    }

    private void getProducts() {
        Call<CategoryProducts> call = mercadonaAPIService.getCategoryById(categoryId);
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<CategoryProducts> call, @NonNull Response<CategoryProducts> response) {
                if (response.isSuccessful()) {
                    CategoryProducts categoryProducts = response.body();
                    List<Product> products = Objects.requireNonNull(categoryProducts).getCategories().stream().map(
                            CategoryInternal::getProducts).flatMap(
                            Collection::stream).collect(Collectors.toList());
                    homeAdapter.setProducts(products);
                }
            }

            @Override
            public void onFailure(@NonNull Call<CategoryProducts> call, @NonNull Throwable t) {

            }
        });
    }
}
