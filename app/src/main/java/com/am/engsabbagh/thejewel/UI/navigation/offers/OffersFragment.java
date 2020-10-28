package com.am.engsabbagh.thejewel.UI.navigation.offers;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.am.engsabbagh.thejewel.R;

public class OffersFragment extends Fragment {

    private OffersViewModel offersViewModel;

    public static OffersFragment newInstance() {
        return new OffersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        offersViewModel = new ViewModelProvider(this).get(OffersViewModel.class);
        View root = inflater.inflate(R.layout.fragment_offers, container, false);
        final TextView text = (TextView) root.findViewById(R.id.text_offers);

        offersViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                text.setText(s);
            }
        });
        return root;
    }//end onCreate
} //end class

