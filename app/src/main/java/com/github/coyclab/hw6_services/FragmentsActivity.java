package com.github.coyclab.hw6_services;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FragmentsActivity extends AppCompatActivity {

    private EditText mLoginEditText;
    private EditText mPasswordEditText;
    private Button mSignInButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        mSignInButton = (Button) findViewById(R.id.btn_sign_in);
        mLoginEditText = (EditText) findViewById(R.id.edittext_login);
        mPasswordEditText = (EditText) findViewById(R.id.edittext_password);

        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mLoginEditText.getText().equals("Login")&& mPasswordEditText.equals("Password")){
                    // Show Success-fragment
                } else {
                    // Show Wrong-fragment
                }
            }
        });
    }
}
