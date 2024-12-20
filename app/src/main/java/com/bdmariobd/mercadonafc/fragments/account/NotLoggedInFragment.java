package com.bdmariobd.mercadonafc.fragments.account;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bdmariobd.mercadonafc.R;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NotLoggedInFragment extends Fragment {

    private final ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult(
            new FirebaseAuthUIActivityResultContract(),
            this::onSignInResult
    );
    Button btnLogin;
    final AccountFragment accountFragment;

    public NotLoggedInFragment(AccountFragment accountFragment) {
        this.accountFragment = accountFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account_not_logged_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        btnLogin = view.findViewById(R.id.identifyButton);
        btnLogin.setOnClickListener(this::onIdentifyClick);
        Button shoppingCartButton = view.findViewById(R.id.openShoppingCartButton);
        shoppingCartButton.setOnClickListener(v -> accountFragment.onClickShoppingCartButton());
    }

    public void onIdentifyClick(View view) {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build()
        );
        Intent signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setTheme(R.style.AppTheme)
                .setLogo(R.drawable.mercadonalogo)
                .setIsSmartLockEnabled(true)
                .build();
        signInLauncher.launch(signInIntent);

    }

    private void onSignInResult(FirebaseAuthUIAuthenticationResult result) {
        IdpResponse response = result.getIdpResponse();
        if (result.getResultCode() == RESULT_OK) {
            Log.i("NotLoggedInFragment", "User: logged in");
        } else {
            Log.i("NotLoggedInFragment", "Error:  " + Objects.requireNonNull(response.getError()).getErrorCode());
        }
    }
}
