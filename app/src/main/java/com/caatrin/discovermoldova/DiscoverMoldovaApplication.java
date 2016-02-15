package com.caatrin.discovermoldova;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by ecaterinagaleru on 2/15/16.
 */
public class DiscoverMoldovaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
