package com.github.coyclab.hw6_services.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.coyclab.hw6_services.R;
import com.github.coyclab.hw6_services.fragments.IncorrectFragment;
import com.github.coyclab.hw6_services.fragments.SuccessFragment;

import java.util.concurrent.TimeUnit;

public class FragmentsActivity extends Activity {

    private EditText mLoginEditText;
    private EditText mPasswordEditText;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        final Button signInButton = findViewById(R.id.btn_sign_in);
        mLoginEditText = findViewById(R.id.edittext_login);
        mPasswordEditText = findViewById(R.id.edittext_password);

        signInButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {
                final String login = mLoginEditText.getText().toString();
                final String password = mPasswordEditText.getText().toString();

                if (login.equals(getString(R.string.correct_login)) && password.equals(getString(R.string.correct_password))) {
                    // Show Success-fragment & launch Player activity
                    showFragment(new SuccessFragment());
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (final InterruptedException pE) {
                        pE.printStackTrace();
                    }
                    final Intent intent = new Intent(FragmentsActivity.this, PlayerActivity.class);
                    startActivity(intent);

                } else {
                    // Show Incorrect-fragment
                    showFragment(new IncorrectFragment());
                }
            }
        });
    }

    private void showFragment(final Fragment pFragment) {
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, pFragment);
        transaction.commit();
    }
}
