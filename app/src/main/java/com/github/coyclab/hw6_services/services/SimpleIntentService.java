package com.github.coyclab.hw6_services.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class SimpleIntentService extends IntentService {

    private String TAG = getClass().getSimpleName();

    public SimpleIntentService() {
        super("Intent service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String firstParam = intent.getStringExtra("First param");
        String secondParam = intent.getStringExtra("Second param");

        Log.d(TAG, "onHandleIntent START: " + firstParam + secondParam );
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "onHandleIntent FINISH: " + firstParam + secondParam );
    }
}
