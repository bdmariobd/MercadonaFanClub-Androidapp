package com.bdmariobd.mercadonafc;

import android.net.Uri;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class MercadonaCFApplication extends android.app.Application {

    private FirebaseAuth mAuth;
    @Override
    public void onCreate() {
        super.onCreate();
        mAuth = FirebaseAuth.getInstance();
    }


    public boolean isAutenticated() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        return currentUser != null;
    }

    public void logout() {
        mAuth.signOut();
    }

    public String getName() {
        return this.isAutenticated() ? Objects.requireNonNull(mAuth.getCurrentUser()).getDisplayName() : getResources().getString(R.string.user_not_existing);
    }

    public Uri getPhotoUrl() {
        return this.isAutenticated() ? Objects.requireNonNull(mAuth.getCurrentUser()).getPhotoUrl() : null;
    }

    public String getUserId() {
        return this.isAutenticated() ? Objects.requireNonNull(mAuth.getCurrentUser()).getUid() : null;
    }




}
