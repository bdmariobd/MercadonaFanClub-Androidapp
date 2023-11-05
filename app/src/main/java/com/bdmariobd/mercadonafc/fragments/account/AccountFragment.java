package com.bdmariobd.mercadonafc.fragments.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.bdmariobd.mercadonafc.MercadonaCFApplication;
import com.bdmariobd.mercadonafc.R;

public class AccountFragment extends Fragment {

    MercadonaCFApplication application;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (MercadonaCFApplication) requireActivity().getApplication();
        setFragmentBasedOnAuth();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        setFragmentBasedOnAuth();
    }

    public void setFragmentBasedOnAuth() {
        MercadonaCFApplication application = (MercadonaCFApplication) requireActivity().getApplication();
        if (!application.isAutenticated()) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.userLogedFragmentContainer, new NotLoggedInFragment()).commit();
        } else {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.userLogedFragmentContainer, new LoggedInFragment()).commit();
        }
        String photoUrl = application.getPhotoUrl() != null ? application.getPhotoUrl().toString() : "";
    }

}
