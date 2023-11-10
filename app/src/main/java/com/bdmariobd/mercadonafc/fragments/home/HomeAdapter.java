package com.bdmariobd.mercadonafc.fragments.home;

import android.content.Intent;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bdmariobd.mercadonafc.R;
import com.bdmariobd.mercadonafc.activities.product_detail.ProductActivity;
import com.bdmariobd.mercadonafc.models.Product;
import com.google.android.material.card.MaterialCardView;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ProductPreviewViewHolder> {

    List<Product> products;

    public HomeAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductPreviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_preview, parent, false);
        return new ProductPreviewViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductPreviewViewHolder holder, int position) {
        holder.bind(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    public static class ProductPreviewViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView productCard;
        TextView productName, productPrice, productDescription;
        ImageView productImage;

        public ProductPreviewViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_preview_title);
            productPrice = itemView.findViewById(R.id.product_preview_price);
            productDescription = itemView.findViewById(R.id.product_preview_info);
            productImage = itemView.findViewById(R.id.product_preview_thumb);
            productCard = itemView.findViewById(R.id.product_preview_card);
        }

        public void bind(Product product) {
            productName.setText(product.getDisplayName());
            if (product.getPriceInstructions().getPreviousUnitPrice() != null) {
                SpannableString spannableString = new SpannableString(product.getPriceInstructions().getPreviousUnitPrice() + "€ " +
                        product.getPriceInstructions().getUnitPrice() + "€");
                spannableString.setSpan(new StrikethroughSpan(), 0, product.getPriceInstructions().getPreviousUnitPrice().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                productPrice.setText(spannableString);
            } else {
                productPrice.setText(product.getPriceInstructions().getUnitPrice() + "€");
            }
            String description = "";
            if(product.getPackaging() != null)
            description += product.getPackaging() + ":";
            else description += "Unidad:";
            productDescription.setText(description);
            Picasso.get()
                    .load(product.getThumbnail())
                    .placeholder(R.drawable.baseline_preview_24)
                    .error(R.drawable.baseline_broken_image_24)
                    .into(productImage);
            productCard.setOnClickListener(v -> {
                Intent myIntent = new Intent(itemView.getContext(), ProductActivity.class);
                myIntent.putExtra("product", new Gson().toJson(product));
                itemView.getContext().startActivity(myIntent);
            });
        }
    }
}
