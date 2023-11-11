package com.bdmariobd.mercadonafc.activities.product_detail;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bdmariobd.mercadonafc.R;
import com.bdmariobd.mercadonafc.api.MercadonaAPIService;
import com.bdmariobd.mercadonafc.models.Product;
import com.bdmariobd.mercadonafc.utils.DateConverter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.RatingViewHolder> {
    final List<Review> reviewList;
    Boolean isUser = false;

    public ReviewAdapter() {
        this.reviewList = new ArrayList<>();
    }

    public ReviewAdapter(Boolean isUser) {
        this.reviewList = new ArrayList<>();
        this.isUser = isUser;
    }

    @NonNull
    @Override
    public RatingViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rating_item, parent, false);
        return new RatingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RatingViewHolder holder, int position) {
        holder.bind(reviewList.get(position), isUser);
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList.clear();
        this.reviewList.addAll(reviewList);
        this.notifyDataSetChanged();
    }

    public static class RatingViewHolder extends RecyclerView.ViewHolder {
        private final TextView user, date, review, verified;
        // private final ImageView userImage;
        private final RatingBar ratingBar;

        public RatingViewHolder(@NonNull View itemView) {
            super(itemView);
            user = itemView.findViewById(R.id.rating_item_ratingUser);
            date = itemView.findViewById(R.id.rating_item_ratingText);
            review = itemView.findViewById(R.id.rating_item_review);
            // userImage = itemView.findViewById(R.id.rating_item_ratingImage);
            ratingBar = itemView.findViewById(R.id.rating_item_rating);
            verified = itemView.findViewById(R.id.tvVerified);
        }

        public void bind(Review review, Boolean isUser) {
            if (isUser) {
                this.user.setText(review.getProductName());
                LinearLayout linearLayout = itemView.findViewById(R.id.rating_item_layout);
                linearLayout.setOnClickListener(v -> {
                    Intent intent = new Intent(itemView.getContext(), ProductActivity.class);
                    intent.putExtra("product", new Gson().toJson(new Product(review.getProductId())));
                    itemView.getContext().startActivity(intent);
                });
            } else {
                this.user.setText(review.getAuthor());
            }
            this.date.setText(DateConverter.convertToFormat(review.getDate()));
            this.review.setText(review.getReview());
            this.ratingBar.setRating(review.getRating());
            if (review.getVerified()) {
                this.verified.setVisibility(View.VISIBLE);
            } else {
                this.verified.setVisibility(View.GONE);
            }
        }
    }
}
