package com.noveo.android.internship.ridetogether.app.model.service;


import android.content.Context;

public interface Manager {

    void getEvents();

    void getEvent();

    void getComments();

    void getRoute();

    void subscribe(CharSequence action);

    void setContext(Context context);
}