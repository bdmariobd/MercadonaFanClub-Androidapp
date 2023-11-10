package com.bdmariobd.mercadonafc.activities.product_detail;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bdmariobd.mercadonafc.R;
import com.squareup.picasso.Picasso;

public class FullScreenImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        ImageView imageView = findViewById(R.id.imageView);
        String path = getIntent().getStringExtra("image");
        Picasso.get().load(path).into(imageView);
    }
}
