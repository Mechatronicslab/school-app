package com.example.juli_soep.school;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

public class App extends Application {
    private static Application sApplication;
    private static Prefs2 preferences;

    public static Application getApplication() {
        return sApplication;
    }

    public static Context getContext() {
        return getApplication().getApplicationContext();
    }

    public static Prefs2 getPref() {
        return preferences;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        preferences = new Prefs2(sApplication);
        //Mapbox.getInstance(sApplication, getString(R.string.fake_key));
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
