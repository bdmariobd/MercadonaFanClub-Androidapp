package com.bdmariobd.mercadonafc.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.DialogFragment;

import com.bdmariobd.mercadonafc.R;
import com.bdmariobd.mercadonafc.activities.product_detail.ProductActivity;
import com.bdmariobd.mercadonafc.activities.product_detail.Review;
import com.bdmariobd.mercadonafc.models.Product;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import java.util.UUID;

public class RatingDialog extends DialogFragment {

    Product product;
    Float rating;

    RatingBar ratingBar;

    TextInputEditText reviewEditText;

    public RatingDialog(Product product, Float rating) {
        this.product = product;
        this.rating = rating;
    }

    @NonNull
    @Override
    public AppCompatDialog onCreateDialog(Bundle savedInstanceState) {
        final ProductActivity productActivity = (ProductActivity) requireActivity();
        assert productActivity != null;
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(productActivity);
        builder
                .setTitle(R.string.rate_this_product)
                .setMessage(getResources().getString(R.string.tell_us_about) + " " + product.getDisplayName())
                .setPositiveButton(
                        getString(R.string.rate_this_product),
                        (dialog, which) -> {
                            productActivity.sendProductReview(getReview());
                        }
                )
                .setNegativeButton(
                        getString(android.R.string.cancel),
                        (dialog, which) -> {
                        }
                )
                .setView(R.layout.fragment_rating);

        return builder.create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rating, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ratingBar = view.findViewById(R.id.ratingBarFragment);
        ratingBar.setRating(rating);
        reviewEditText = view.findViewById(R.id.ratingDialogText);
    }

    private Review getReview() {
        String review = reviewEditText.getText().toString();
        Float rating = ratingBar.getRating();
        UUID uuid = UUID.randomUUID();
        return new Review(review,rating, "PEPE", uuid.toString());
    }
}