package com.example.realtimelanguagechange;

import android.app.Application;
import android.content.Context;

import com.example.realtimelanguagechange.Helper.LocalHelper;

public class MainApplication extends Application {


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocalHelper.onAttach(base,"en"));

    }
}
