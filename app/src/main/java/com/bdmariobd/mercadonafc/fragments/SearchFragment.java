package com.bdmariobd.mercadonafc.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bdmariobd.mercadonafc.R;
import com.bdmariobd.mercadonafc.api.MercadonaAPIService;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner;
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions;
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning;

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
}
