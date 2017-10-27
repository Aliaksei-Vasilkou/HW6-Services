package com.github.coyclab.hw6_services.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.coyclab.hw6_services.R;
import com.github.coyclab.hw6_services.fragments.ControlPanelFragment;

public class PlayerActivity extends Activity {

    private Button mBtnShowControlPanel;
    private FragmentManager mFragmentManager;
    private final String CONTROL_PANEL_TAG = "ControlPanel";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        mFragmentManager = getFragmentManager();

        mBtnShowControlPanel = findViewById(R.id.btn_show_control_panel);
        mBtnShowControlPanel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View pView) {
                final Fragment fragment = mFragmentManager.findFragmentByTag(CONTROL_PANEL_TAG);
                if (fragment == null) {
                    showControlPanel();
                } else {
                    hideControlPanel();
                }
            }
        });
    }

    void showControlPanel() {
        final ControlPanelFragment fragment = new ControlPanelFragment();
        final FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        transaction.add(R.id.control_panel_container, fragment, CONTROL_PANEL_TAG);
        transaction.commit();

        mBtnShowControlPanel.setText(R.string.btn_hide_control_panel_name);
    }

    void hideControlPanel() {
        final Fragment fragment = mFragmentManager.findFragmentByTag(CONTROL_PANEL_TAG);
        final FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.remove(fragment).commit();

        mBtnShowControlPanel.setText(R.string.btn_show_control_panel_name);
    }
}
