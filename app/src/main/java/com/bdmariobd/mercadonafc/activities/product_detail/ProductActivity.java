package com.bdmariobd.mercadonafc.activities.product_detail;

import static java.lang.Math.round;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bdmariobd.mercadonafc.R;
import com.bdmariobd.mercadonafc.api.MercadonaAPIService;
import com.bdmariobd.mercadonafc.dialogs.RatingDialog;
import com.bdmariobd.mercadonafc.models.Photo;
import com.bdmariobd.mercadonafc.models.Product;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductActivity extends AppCompatActivity {
    RecyclerView carouselRecyclerView, reviewRecyclerView;
    ReviewAdapter reviewAdapter;
    private Product product;
    private TextView productTitle, productInfo, productReviews;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Intent intent = getIntent();
        product = new Gson().fromJson(intent.getStringExtra("product"), Product.class);

        carouselRecyclerView = findViewById(R.id.carusel_recicler_view);
        reviewRecyclerView = findViewById(R.id.ratingsRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        reviewRecyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(reviewRecyclerView.getContext(),
                layoutManager.getOrientation());
        reviewRecyclerView.addItemDecoration(dividerItemDecoration);
        reviewRecyclerView.setHasFixedSize(false);
        reviewRecyclerView.setNestedScrollingEnabled(false);

        reviewAdapter = new ReviewAdapter();
        reviewRecyclerView.setAdapter(reviewAdapter);

        RatingBar ratingBar1 = findViewById(R.id.ratingBar);

        ratingBar1.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> this.showDialog(product, rating));

        retrieveProductReviews(product.getId());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.api_base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MercadonaAPIService service = retrofit.create(MercadonaAPIService.class);
        Call<Product> call = service.getProductById(product.getId());

        ImageAdapter adapter = new ImageAdapter(ProductActivity.this, new ArrayList<>());
        carouselRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener((imageView, path) -> startActivity(new Intent(ProductActivity.this, FullScreenImageActivity.class)
                .putExtra("image", path), ActivityOptions.makeSceneTransitionAnimation(ProductActivity.this, imageView, "image").toBundle())
        );

        call.enqueue(new Callback<>() {
                         @Override
                         public void onResponse(@NonNull Call<Product> call, @NonNull Response<Product> response) {
                             product = response.body();
                             List<Photo> arrayList = Objects.requireNonNull(product).getPhotos();
                             adapter.setPhotoList(arrayList);
                             productTitle = findViewById(R.id.productTitle);
                             productInfo = findViewById(R.id.productInfo);
                             productTitle.setText(product.getDisplayName());
                             if (product.getBrand() == null) {
                                 product.setBrand("");
                             }
                             String info = product.getBrand() + " " + product.getPriceInstructions().getUnitPrice() + "€";
                             productInfo.setText(info);
                             carouselRecyclerView.setVisibility(arrayList.size() > 0 ? android.view.View.VISIBLE : android.view.View.GONE);
                         }

                         @Override
                         public void onFailure(@NonNull Call<Product> call, @NonNull Throwable t) {

                         }
                     }
        );


    }

    public void showDialog(Product product, Float rating) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        RatingDialog newFragment = new RatingDialog(product, rating);
        newFragment.show(fragmentManager, "rating");
    }

    public void sendProductReview(String productId, Review review) {
        db.collection(getResources().getString(R.string.reviews_db_name)).document(productId)
                .collection(getResources().getString(R.string.singleEntrance_db_name))
                .document(review.getId())
                .set(review)
                .addOnSuccessListener(documentReference -> {
                })
                .addOnFailureListener(e -> {
                });
    }

    public void retrieveProductReviews(String productId) {
        this.db = FirebaseFirestore.getInstance();
        db.collection(getResources().getString(R.string.reviews_db_name))
                .document(productId)
                .collection(getResources().getString(R.string.singleEntrance_db_name))
                .orderBy("verified" , com.google.firebase.firestore.Query.Direction.DESCENDING)
                .orderBy("date", com.google.firebase.firestore.Query.Direction.DESCENDING)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        List<Review> reviewList = task.getResult().toObjects(Review.class);
                        int totalReviews = reviewList.size();
                        double averageRating = reviewList.stream().mapToDouble(Review::getRating).sum() / totalReviews;
                        productReviews = findViewById(R.id.product_reviews_tv);
                        if (totalReviews == 0) {
                            productReviews.setText(getResources().getString(R.string.no_reviews));
                        } else {
                            productReviews.setText(
                                    round(averageRating * 10.0) / 10.0
                                            + "(" + totalReviews + " "
                                            + getResources().getString(R.string.totalReviews)
                                            + ")");
                            Collections.reverse(reviewList);
                            reviewAdapter.setReviewList(reviewList);
                        }

                    } else {
                        Log.w("TAG", "Error getting documents.", task.getException());
                    }

                });
    }
}
