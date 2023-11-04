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
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    private List<Product> products;
    private MercadonaAPIService mercadonaAPIService;
    private HomeAdapter homeAdapter;
    private TabLayout tabLayout;
    private final TabLayout.OnTabSelectedListener onTabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            switch (tab.getPosition()) {
                case 0:
                    getTrendingProducts();
                    break;
                case 1:
                    getPriceDrops();
                    break;
                case 2:
                    getNewProducts();
                    break;
            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
            recyclerView.smoothScrollToPosition(0);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.api_base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mercadonaAPIService = retrofit.create(MercadonaAPIService.class);
        homeAdapter = new HomeAdapter(new ArrayList<>());
        getPriceDrops();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = getView().findViewById(R.id.hometab_tab);
        tabLayout.selectTab(tabLayout.getTabAt(1));
        tabLayout.addOnTabSelectedListener(onTabSelectedListener);
        recyclerView = getView().findViewById(R.id.home_rv);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(homeAdapter);
    }

    private void getTrendingProducts() {
        //TODO: get trending products from firebase
    }

    private void getPriceDrops() {
        Call<PriceDrops> call = mercadonaAPIService.getPriceDrops();
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

    private void getNewProducts() {
        Call<PriceDrops> call = mercadonaAPIService.getNewArrivals();
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

}
