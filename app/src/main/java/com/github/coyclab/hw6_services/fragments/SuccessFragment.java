package com.github.coyclab.hw6_services.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.coyclab.hw6_services.Constants;
import com.github.coyclab.hw6_services.R;

public class SuccessFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_success, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(new Intent(Constants.LOGIN_KEY));
        getActivity().finish();

        super.onActivityCreated(savedInstanceState);
    }
}
