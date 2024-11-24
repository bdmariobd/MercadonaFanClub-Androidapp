package com.bdmariobd.mercadonafc.fragments.search;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bdmariobd.mercadonafc.R;
import com.bdmariobd.mercadonafc.activities.MainActivity;
import com.bdmariobd.mercadonafc.api.MercadonaAPIService;
import com.bdmariobd.mercadonafc.models.Categories;
import com.bdmariobd.mercadonafc.models.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchFragment extends Fragment {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<Pair<String, String>>> expandableListDetail; // Pair<product name, product id>
    private MercadonaAPIService apiService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.api_base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(MercadonaAPIService.class);
        expandableListTitle = new ArrayList<>();
        expandableListDetail = new HashMap<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        expandableListView = view.findViewById(R.id.searcg_fragment_list);
        this.setUpExpandableListView();
        this.fetchCategories();
    }


    private void setUpExpandableListView() {
        expandableListTitle = new ArrayList<>(expandableListDetail.keySet());
        expandableListAdapter = new CategoriesExpandableListAdapter(getContext(), expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            // TODO open products list
            MainActivity mainActivity = (MainActivity) this.requireActivity();
            String categoryId = Objects.requireNonNull(expandableListDetail.get(expandableListTitle.get(groupPosition))).get(childPosition).second;
            mainActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new ProductsByCategoryFragment(categoryId)).commit();
            return false;
        });
    }


    private void fetchCategories() {
        Call<Categories> call = apiService.getCategories();
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<Categories> call, @NonNull Response<Categories> response) {
                Categories categories = response.body();
                expandableListTitle = Objects.requireNonNull(categories).getResults().stream()
                        .map(Result::getName)
                        .collect(Collectors.toList());
                expandableListDetail = new HashMap<>(categories.getResults().stream()
                        .collect(Collectors.toMap(
                                Result::getName,
                                result -> result.getCategories().stream()
                                        .map(category -> new Pair<>(category.getName(), category.getId().toString()))
                                        .collect(Collectors.toList())
                        )));
                expandableListAdapter = new CategoriesExpandableListAdapter(getContext(), expandableListTitle, expandableListDetail);
                expandableListView.setAdapter(expandableListAdapter);
            }

            @Override
            public void onFailure(@NonNull Call<Categories> call, @NonNull Throwable t) {

            }
        });
    }
}
