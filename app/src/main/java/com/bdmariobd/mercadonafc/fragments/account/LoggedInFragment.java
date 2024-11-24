package com.bdmariobd.mercadonafc.fragments.account;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bdmariobd.mercadonafc.MercadonaCFApplication;
import com.bdmariobd.mercadonafc.R;
import com.bdmariobd.mercadonafc.activities.product_detail.Review;
import com.bdmariobd.mercadonafc.activities.product_detail.ReviewAdapter;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.List;
import java.util.Objects;

public class LoggedInFragment extends Fragment {

    final AccountFragment accountFragment;
    Button btnCloseSession;
    TextView txtUserName , titleReviews;
    RecyclerView recyclerView;
    ReviewAdapter reviewAdapter;

    public LoggedInFragment(AccountFragment accountFragment) {
        this.accountFragment = accountFragment;
    }

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
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MercadonaCFApplication application = (MercadonaCFApplication) requireActivity().getApplication();
        btnCloseSession = view.findViewById(R.id.closeSessionButton);
        btnCloseSession.setOnClickListener(this::onCloseSessionClick);
        txtUserName = view.findViewById(R.id.tvAccountUsername);
        titleReviews = view.findViewById(R.id.tv_logged_in_reviews);
        txtUserName.setText(application.getName());
        recyclerView = view.findViewById(R.id.user_profile_reviews);
        reviewAdapter = new ReviewAdapter(true);
        recyclerView.setAdapter(reviewAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation()));
        retrieveUserReviews(view);
        Button shoppingCartButton = view.findViewById(R.id.openShoppingCartButton);
        shoppingCartButton.setOnClickListener(v -> accountFragment.onClickShoppingCartButton());
    }

    private void onCloseSessionClick(View view) {
        Application application = requireActivity().getApplication();
        ((MercadonaCFApplication) application).logout();
        accountFragment.setFragmentBasedOnAuth();
    }

    private void retrieveUserReviews(View v) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        String userId = ((MercadonaCFApplication) requireActivity().getApplication()).getUserId();
        db.collectionGroup(getResources().getString(R.string.singleEntrance_db_name)).whereEqualTo("userId", userId).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                List<Review> reviews = task.getResult().toObjects(Review.class);
                reviewAdapter.setReviewList(reviews);
                if(reviews.size() == 0) {
                    titleReviews.setText(v.getResources().getString(R.string.no_reviews));
                } else {
                    titleReviews.setText(titleReviews.getText() + " (" + reviews.size() + ")");
                }
            } else {
                Log.e("ERRORAccount", Objects.requireNonNull(Objects.requireNonNull(task.getException()).getMessage()));
            }
        });
    }

}
