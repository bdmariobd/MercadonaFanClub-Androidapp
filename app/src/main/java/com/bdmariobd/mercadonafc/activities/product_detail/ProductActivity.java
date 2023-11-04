package com.bdmariobd.mercadonafc.activities.product_detail;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bdmariobd.mercadonafc.R;
import com.bdmariobd.mercadonafc.api.MercadonaAPIService;
import com.bdmariobd.mercadonafc.dialogs.RatingDialog;
import com.bdmariobd.mercadonafc.models.Photo;
import com.bdmariobd.mercadonafc.models.Product;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductActivity extends AppCompatActivity implements FirebaseAuth.AuthStateListener {
    RecyclerView carouselRecyclerView, reviewRecyclerView;
    ReviewAdapter reviewAdapter;
    private MercadonaAPIService service;
    private Product product;
    private TextView productTitle, productInfo;
    private RatingBar ratingBar;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Intent intent = getIntent();
        product = new Gson().fromJson(intent.getStringExtra("product"), Product.class);

        carouselRecyclerView = findViewById(R.id.carusel_recicler_view);
        reviewRecyclerView = findViewById(R.id.ratingsRecyclerView);

        reviewAdapter = new ReviewAdapter();
        reviewRecyclerView.setAdapter(reviewAdapter);

        ratingBar = findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            this.showDialog(product, rating);
        });
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.api_base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(MercadonaAPIService.class);
        Call<Product> call = service.getProductById(product.getId());

        call.enqueue(new Callback<Product>() {
                         @Override
                         public void onResponse(Call<Product> call, Response<Product> response) {
                             product = response.body();
                             List<Photo> arrayList = product.getPhotos();
                             ImageAdapter adapter = new ImageAdapter(ProductActivity.this, arrayList);
                             carouselRecyclerView.setAdapter(adapter);
                             productTitle = findViewById(R.id.productTitle);
                             productInfo = findViewById(R.id.productInfo);
                             productTitle.setText(product.getDisplayName());
                             String info = product.getBrand() + " " + product.getPriceInstructions().getUnitPrice() + "€";
                             productInfo.setText(info);

                             retrieveProductReviews(product.getId());
                         }

                         @Override
                         public void onFailure(Call<Product> call, Throwable t) {

                         }
                     }
        );

        this.db = FirebaseFirestore.getInstance();
    }

    public void showDialog(Product product, Float rating) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        RatingDialog newFragment = new RatingDialog(product, rating);
        newFragment.show(fragmentManager, "rating");
    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        // TODO LOCK OR UNLOCK RATING
    }

    public void sendProductReview(Review review) {
        db.collection(getResources().getString(R.string.reviews_db_name)).document(product.getId())
                .set(review)
                .addOnSuccessListener(documentReference -> {
                })
                .addOnFailureListener(e -> {
                });
    }

    public void retrieveProductReviews(String productId) {
        db.collection(getResources().getString(R.string.reviews_db_name))
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        List<Review> reviews = task.getResult().toObjects(Review.class);
                        reviewAdapter.setReviewList(reviews);
                    } else {
                        Log.w("TAG", "Error getting documents.", task.getException());
                    }

                });

    }
}
