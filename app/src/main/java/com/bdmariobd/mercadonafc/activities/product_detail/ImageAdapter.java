package com.bdmariobd.mercadonafc.activities.product_detail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bdmariobd.mercadonafc.R;
import com.bdmariobd.mercadonafc.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    final Context context;
    List<Photo> photoList;

    OnItemClickListener onItemClickListener;


    public ImageAdapter(Context context, List<Photo> photoList) {
        this.context = context;
        this.photoList = photoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.carusel_item_image_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get()
                .load(photoList.get(position).getRegular())
                .placeholder(R.drawable.baseline_preview_24)
                .error(R.drawable.baseline_broken_image_24)
                .into(holder.imageView);
        holder.itemView.setOnClickListener(view -> onItemClickListener.onClick(holder.imageView, photoList.get(position).getRegular()));
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onClick(ImageView imageView, String path);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.list_item_image);
        }


    }
}