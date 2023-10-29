package com.bdmariobd.mercadonafc.fragments.Account;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.bdmariobd.mercadonafc.MercadonaCFApplication;
import com.bdmariobd.mercadonafc.R;

public class LoggedInFragment extends Fragment {

    Button btnCloseSession;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account_logged_in_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        btnCloseSession = view.findViewById(R.id.closeSessionButton);
        btnCloseSession.setOnClickListener(this::onCloseSessionClick);
    }

    private void onCloseSessionClick(View view) {
        Application application = requireActivity().getApplication();
        ((MercadonaCFApplication) application).logout();

    }
}
