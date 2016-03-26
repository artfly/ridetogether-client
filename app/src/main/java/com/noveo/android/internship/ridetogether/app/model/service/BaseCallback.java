package com.noveo.android.internship.ridetogether.app.model.service;

import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;

public abstract class BaseCallback<T> implements Callback<T> {
    public static final String LOG_TAG = "CALLBACK_TAG";

    @Override
    public void onFailure(Call call, Throwable t) {
        Log.e(LOG_TAG, t.getMessage());
    }
}