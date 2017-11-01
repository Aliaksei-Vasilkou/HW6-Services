package com.github.coyclab.hw6_services.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.github.coyclab.hw6_services.R;
import com.github.coyclab.hw6_services.fragments.ControlPanelFragment;

public class PlayerActivity extends Activity {

    private Button mBtnShowControlPanel;
    private FragmentManager mFragmentManager;
    private final String CONTROL_PANEL_TAG = "ControlPanel";
    private ImageView mImageView;
    Button takePicture;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        mFragmentManager = getFragmentManager();
        mImageView = findViewById(R.id.action_image);
        takePicture = findViewById(R.id.take_picture);
        takePicture.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View pView) {
                final Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });

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

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            final Bundle extras = data.getExtras();
            final Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }


    }
}
