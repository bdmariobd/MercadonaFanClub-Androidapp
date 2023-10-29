package com.bdmariobd.mercadonafc.fragments.Account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.bdmariobd.mercadonafc.MercadonaCFApplication;
import com.bdmariobd.mercadonafc.R;

public class AccountFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MercadonaCFApplication application = (MercadonaCFApplication) requireActivity().getApplication();
        if (!application.isAutenticated()) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.userLogedFragmentContainer, new NotLoggedInFragment()).commit();
        } else {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.userLogedFragmentContainer, new LoggedInFragment()).commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, container, false);
    }
}
