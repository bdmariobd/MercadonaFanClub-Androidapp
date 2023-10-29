package com.bdmariobd.mercadonafc.fragments.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bdmariobd.mercadonafc.R;
import com.bdmariobd.mercadonafc.api.MercadonaAPIService;
import com.bdmariobd.mercadonafc.models.PriceDrops;
import com.bdmariobd.mercadonafc.models.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    private List<Product> products;
    private MercadonaAPIService mercadonaAPIService;
    private HomeAdapter homeAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.api_base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mercadonaAPIService = retrofit.create(MercadonaAPIService.class);
        Call<PriceDrops> call = mercadonaAPIService.getPriceDrops();
        homeAdapter = new HomeAdapter(new ArrayList<>());

        call.enqueue(new Callback<PriceDrops>() {
            @Override
            public void onResponse(Call<PriceDrops> call, Response<PriceDrops> response) {
                if (response.isSuccessful()) {
                    PriceDrops priceDrops = response.body();
                    products = priceDrops.getProducts();
                    homeAdapter.setProducts(products);
                }
            }

            @Override
            public void onFailure(Call<PriceDrops> call, Throwable t) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getView().findViewById(R.id.home_rv);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(homeAdapter);
    }
}
