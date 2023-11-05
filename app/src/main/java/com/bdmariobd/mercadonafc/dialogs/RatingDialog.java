package com.bdmariobd.mercadonafc.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.DialogFragment;

import com.bdmariobd.mercadonafc.MercadonaCFApplication;
import com.bdmariobd.mercadonafc.R;
import com.bdmariobd.mercadonafc.activities.product_detail.ProductActivity;
import com.bdmariobd.mercadonafc.activities.product_detail.Review;
import com.bdmariobd.mercadonafc.models.Product;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.UUID;

public class RatingDialog extends DialogFragment {

    Product product;
    Float rating;

    RatingBar ratingBar;

    TextInputLayout reviewEditText;

    MercadonaCFApplication application;

    public RatingDialog(Product product, Float rating) {
        this.product = product;
        this.rating = rating;
    }

    @NonNull
    @Override
    public AppCompatDialog onCreateDialog(Bundle savedInstanceState) {
        final ProductActivity productActivity = (ProductActivity) requireActivity();
        application = (MercadonaCFApplication) productActivity.getApplication();
        assert productActivity != null;
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View DialogView = inflater.inflate(R.layout.fragment_rating,null);
        this.onViewCreated(DialogView, savedInstanceState);
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(productActivity);
        builder
                .setTitle(R.string.rate_this_product)
                .setMessage(getResources().getString(R.string.tell_us_about) + " " + product.getDisplayName())
                .setPositiveButton(
                        getString(R.string.rate_this_product),
                        (dialog, which) -> {
                            productActivity.sendProductReview(product.getId(), getReview());
                        }
                )
                .setNegativeButton(
                        getString(android.R.string.cancel),
                        (dialog, which) -> {
                        }
                )
                .setView(DialogView);

        AppCompatDialog dialog = builder.create();
        dialog.setOnShowListener(dialog1 -> {
            if(!application.isAutenticated())
                ((AlertDialog) dialog1).getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
        });
        return dialog;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        ratingBar = view.findViewById(R.id.ratingBarFragment);
        ratingBar.setRating(rating);
        reviewEditText = view.findViewById(R.id.ratingDialogTextLayout);
        if(!application.isAutenticated()) {
            reviewEditText.setEnabled(false);
            reviewEditText.setHint(R.string.login_to_review);
        }
    }

    private Review getReview() {
        String review = reviewEditText.getEditText().getText().toString();
        String username = application.getName();
        Float rating = ratingBar.getRating();
        UUID uuid = UUID.randomUUID();
        Review reviewObj = new Review(review, rating, username, uuid.toString());
        return reviewObj;
    }
}