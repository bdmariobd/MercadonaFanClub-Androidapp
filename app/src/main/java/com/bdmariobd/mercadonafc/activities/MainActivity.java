package com.bdmariobd.mercadonafc.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bdmariobd.mercadonafc.MercadonaCFApplication;
import com.bdmariobd.mercadonafc.R;
import com.bdmariobd.mercadonafc.fragments.account.AccountFragment;
import com.bdmariobd.mercadonafc.fragments.home.HomeFragment;
import com.bdmariobd.mercadonafc.fragments.search.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;


public class MainActivity extends AppCompatActivity {
    final Fragment homeFragment = new HomeFragment();
    final Fragment searchFragment = new SearchFragment();
    final Fragment accountFragment = new AccountFragment();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
                    if (item.getItemId() == R.id.menu_home) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, homeFragment).commit();
                    } else if (item.getItemId() == R.id.menu_search) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, searchFragment).commit();
                    } else if (item.getItemId() == R.id.menu_account) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, accountFragment).commit();
                    }
                    return true;
                }
        );
        bottomNavigationView.setSelectedItemId(R.id.menu_home);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, homeFragment).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setAccountTabUserContent();
    }

    private void setAccountTabUserContent() {
        MercadonaCFApplication application = (MercadonaCFApplication) this.getApplication();
        if (application.isAutenticated()) {
            MenuItem userItem = bottomNavigationView.getMenu().findItem(R.id.menu_account);
            userItem.setTitle(application.getName());
            /*if (application.getPhotoUrl() != null) {
                // Load the user's photo URL into the menu item icon
                Uri photoUrl = application.getPhotoUrl();
                if (photoUrl != null) {
                    Picasso.get()
                            .load(photoUrl)
                            .resize(100, 100) // Resize to reduce the image size beforehand
                            .placeholder(R.drawable.baseline_person_24) // Placeholder while loading
                            .error(R.drawable.baseline_person_24) // Fallback if loading fails
                            .into(new MenuItemTarget(userItem, this));
                }
            }*/
        }
    }

    /*class MenuItemTarget implements Target {
        private final MenuItem menuItem;
        private final Context context;


        public MenuItemTarget(MenuItem menuItem, Context context) {
            this.menuItem = menuItem;
            this.context = context;
        }

        @Override
        public void onBitmapLoaded(@NonNull Bitmap bitmap, @NonNull Picasso.LoadedFrom from) {
            if (menuItem == null) return;
            // Resize the bitmap to 24dp x 24dp (convert dp to pixels)
            int iconSize = (int) (24 * context.getResources().getDisplayMetrics().density);
            Bitmap resizedBitmap = Bitmap.createBitmap(bitmap);

            // Set the resized bitmap as the icon
            Drawable drawable = new BitmapDrawable(context.getResources(), resizedBitmap);
            menuItem.setIcon(drawable);
        }


        @Override
        public void onBitmapFailed(@Nullable Exception e, @Nullable Drawable errorDrawable) {
            menuItem.setIcon(errorDrawable); // Set fallback if loading fails
        }

        @Override
        public void onPrepareLoad(@Nullable Drawable placeHolderDrawable) {
            menuItem.setIcon(placeHolderDrawable); // Optional placeholder
        }

    }*/
}