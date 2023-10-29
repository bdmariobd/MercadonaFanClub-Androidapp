package com.bdmariobd.mercadonafc;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bdmariobd.mercadonafc.fragments.Account.AccountFragment;
import com.bdmariobd.mercadonafc.fragments.SearchFragment;
import com.bdmariobd.mercadonafc.fragments.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

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
}