package com.github.coyclab.hw6_services.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.coyclab.hw6_services.R;
import com.github.coyclab.hw6_services.services.PlayerService;
import com.github.coyclab.hw6_services.services.SimpleIntentService;

public class ControlPanelFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_control_panel, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Button btnPlay = getActivity().findViewById(R.id.btn_play);
        Button btnStop = getActivity().findViewById(R.id.btn_stop);
        Button btnRunIntentService = getActivity().findViewById(R.id.btn_start_intent_service);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startService(new Intent(getActivity(), PlayerService.class));
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().stopService(new Intent(getActivity(), PlayerService.class));
            }
        });

        btnRunIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myServiceIntent = new Intent(getActivity(), SimpleIntentService.class);
                getActivity().startService(myServiceIntent.putExtra("First param", "First iteration")
                        .putExtra("Second param", "Param = 1"));
                getActivity().startService(myServiceIntent.putExtra("First param", "Second iteration")
                        .putExtra("Second param", "Param = 2"));
                getActivity().startService(myServiceIntent.putExtra("First param", "Third iteration")
                        .putExtra("Second param", "Param = 3"));
            }
        });
        super.onActivityCreated(savedInstanceState);
    }
}
