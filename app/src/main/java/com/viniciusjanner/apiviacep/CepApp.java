package com.viniciusjanner.apiviacep;

import android.app.Application;
import android.content.Context;

import com.viniciusjanner.apiviacep.di.AppComponent;

public class CepApp extends Application {

    private static Context appContext;
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        appComponent = AppComponent.create();
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
