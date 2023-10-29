package com.bdmariobd.mercadonafc;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
}
