package com.bdmariobd.mercadonafc.fragments.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bdmariobd.mercadonafc.R;
import com.bdmariobd.mercadonafc.models.Product;
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
        TextView productName, productPrice, productDescription, productRatingInfo;
        RatingBar productRating;
        ImageView productImage;

        public ProductPreviewViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_preview_title);
            productPrice = itemView.findViewById(R.id.product_preview_price);
            productDescription = itemView.findViewById(R.id.product_preview_info);
            productRatingInfo = itemView.findViewById(R.id.product_preview_ratinginfo);
            productRating = itemView.findViewById(R.id.product_preview_ratingstars);
            productImage = itemView.findViewById(R.id.product_preview_thumb);
        }

        public void bind(Product product) {
            productName.setText(product.getDisplayName());
            productPrice.setText(product.getPriceInstructions().getUnitPrice() + product.getPriceInstructions().getPreviousUnitPrice());
            String description = "";
            description += product.getPackaging();
            description += " ";
            description += product.getPriceInstructions().getTotalUnits();
            description += " ";
            description += product.getPriceInstructions().getUnitName();
            productDescription.setText(description);
            productRatingInfo.setText("3,4 (32 reviews)");
            productRating.setRating(3.4F);
            Picasso.get()
                    .load(product.getThumbnail())
                    .placeholder(R.drawable.baseline_preview_24)
                    .error(R.drawable.baseline_broken_image_24)
                    .into(productImage);
        }
    }
}
