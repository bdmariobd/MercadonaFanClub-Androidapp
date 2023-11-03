package com.bdmariobd.mercadonafc.activities.product_detail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bdmariobd.mercadonafc.R;
import com.bdmariobd.mercadonafc.api.MercadonaAPIService;
import com.bdmariobd.mercadonafc.models.Photo;
import com.bdmariobd.mercadonafc.models.Product;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductActivity extends AppCompatActivity {
    MercadonaAPIService service;

    Product product;

    TextView productTitle, productInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Intent intent = getIntent();
        product = new Gson().fromJson(intent.getStringExtra("product"), Product.class);

        RecyclerView recyclerView = findViewById(R.id.carusel_recicler_view);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.api_base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(MercadonaAPIService.class);
        Call<Product> call = service.getProductById(product.getId());

        call.enqueue(new Callback<Product>() {
                         @Override
                         public void onResponse(Call<Product> call, Response<Product> response) {
                             Product product = response.body();
                             List<Photo> arrayList = product.getPhotos();
                             ImageAdapter adapter = new ImageAdapter(ProductActivity.this, arrayList);
                             recyclerView.setAdapter(adapter);
                             productTitle = findViewById(R.id.productTitle);
                             productInfo = findViewById(R.id.productInfo);
                             productTitle.setText(product.getDisplayName());
                             String info = product.getBrand() + " " + product.getPriceInstructions().getUnitPrice() + "€";
                             productInfo.setText(info);
                         }

                         @Override
                         public void onFailure(Call<Product> call, Throwable t) {

                         }
                     }
        );
    }
}
