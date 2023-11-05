package com.bdmariobd.mercadonafc.fragments.search;

import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bdmariobd.mercadonafc.R;
import com.bdmariobd.mercadonafc.activities.MainActivity;
import com.bdmariobd.mercadonafc.api.MercadonaAPIService;
import com.bdmariobd.mercadonafc.fragments.home.HomeFragment;
import com.bdmariobd.mercadonafc.models.Categories;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner;
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions;
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchFragment extends Fragment {
    GmsBarcodeScannerOptions options = new GmsBarcodeScannerOptions.Builder()
            .setBarcodeFormats(
                    Barcode.FORMAT_EAN_13
            )
            .build();

    GmsBarcodeScanner scanner;
    Button btnScanBarcode;
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
        scanner = GmsBarcodeScanning.getClient(this.getContext(), options);
        expandableListTitle = new ArrayList<>();
        expandableListDetail = new HashMap<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnScanBarcode = view.findViewById(R.id.buttonScan);
        btnScanBarcode.setOnClickListener(this::onScanBarcodeClick);
        expandableListView = view.findViewById(R.id.searcg_fragment_list);
        this.setUpExpandableListView();
        this.fetchCategories();
    }


    public void onScanBarcodeClick(View view) {
        scanner
                .startScan()
                .addOnSuccessListener(
                        barcode -> {
                            String rawValue = barcode.getRawValue();
                            Log.d("Barcode", rawValue);
                            Toast.makeText(this.getContext(), rawValue, Toast.LENGTH_LONG).show();
                        })
                .addOnCanceledListener(
                        () -> {
                            Log.d("Barcode", "cancelled");
                        })
                .addOnFailureListener(
                        e -> {
                            Log.d("Barcode", e.getMessage());
                        });
    }

    private void setUpExpandableListView() {
        expandableListTitle = new ArrayList<>(expandableListDetail.keySet());
        expandableListAdapter = new CategoriesExpandableListAdapter(getContext(), expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            // TODO open products list
            MainActivity mainActivity = (MainActivity) this.requireActivity();
            String categoryId = expandableListDetail.get(expandableListTitle.get(groupPosition)).get(childPosition).second;
            mainActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new ProductsByCategoryFragment(categoryId)).commit();
            return false;
        });
    }


    private void fetchCategories() {
        Call<Categories> call = apiService.getCategories();
        call.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                Categories categories = response.body();
                expandableListTitle = categories.getResults().stream()
                        .map(result -> result.getName())
                        .collect(Collectors.toList());
                expandableListDetail = new HashMap<>(categories.getResults().stream()
                        .collect(Collectors.toMap(
                                result -> result.getName(),
                                result -> result.getCategories().stream()
                                        .map(category -> new Pair<>(category.getName(), category.getId().toString()))
                                        .collect(Collectors.toList())
                        )));
                expandableListAdapter = new CategoriesExpandableListAdapter(getContext(), expandableListTitle, expandableListDetail);
                expandableListView.setAdapter(expandableListAdapter);
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {

            }
        });
    }
}
