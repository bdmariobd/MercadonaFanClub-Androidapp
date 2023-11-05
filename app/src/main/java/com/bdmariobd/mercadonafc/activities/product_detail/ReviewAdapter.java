package com.bdmariobd.mercadonafc.activities.product_detail;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bdmariobd.mercadonafc.R;
import com.bdmariobd.mercadonafc.utils.DateConverter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.RatingViewHolder> {
    List<Review> reviewList;

    public ReviewAdapter() {
        this.reviewList = new ArrayList<>();
    }

    @NonNull
    @Override
    public RatingViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rating_item, parent, false);
        return new RatingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RatingViewHolder holder, int position) {
        holder.bind(reviewList.get(position));
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
        private final TextView user;
        private final TextView date;
        private final TextView review;
        private final ImageView userImage;
        private final RatingBar ratingBar;

        public RatingViewHolder(@NonNull View itemView) {
            super(itemView);
            user = itemView.findViewById(R.id.rating_item_ratingUser);
            date = itemView.findViewById(R.id.rating_item_ratingText);
            review = itemView.findViewById(R.id.rating_item_review);
            userImage = itemView.findViewById(R.id.rating_item_ratingImage);
            ratingBar = itemView.findViewById(R.id.rating_item_rating);
        }

        public void bind(Review review) {
            this.user.setText(review.getAuthor());
            this.date.setText(DateConverter.convertToFormat(review.getDate()));
            this.review.setText(review.getReview());
            this.ratingBar.setRating(review.getRating());
        }
    }
}
