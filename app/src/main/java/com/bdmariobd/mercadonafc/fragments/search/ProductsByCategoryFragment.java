package com.bdmariobd.mercadonafc.fragments.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bdmariobd.mercadonafc.R;
import com.bdmariobd.mercadonafc.api.MercadonaAPIService;
import com.bdmariobd.mercadonafc.fragments.home.HomeAdapter;
import com.bdmariobd.mercadonafc.models.CategoryProducts;
import com.bdmariobd.mercadonafc.models.Product;

import java.util.ArrayList;
import java.util.List;
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

    private RecyclerView recyclerView;

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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvSearchListProducts);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(homeAdapter);
    }

    private void getProducts() {
        Call<CategoryProducts> call = mercadonaAPIService.getCategoryById(categoryId);
        call.enqueue(new Callback<CategoryProducts>() {
            @Override
            public void onResponse(Call<CategoryProducts> call, Response<CategoryProducts> response) {
                if (response.isSuccessful()) {
                    CategoryProducts categoryProducts = response.body();
                    List<Product> products = categoryProducts.getCategories().stream().map(
                            categoryInternal -> categoryInternal.getProducts()).flatMap(
                            products1 -> products1.stream()).collect(Collectors.toList());
                    homeAdapter.setProducts(products);
                }
            }

            @Override
            public void onFailure(Call<CategoryProducts> call, Throwable t) {

            }
        });
    }
}
