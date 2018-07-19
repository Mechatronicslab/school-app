package com.example.juli_soep.school;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.juli_soep.school.login.model.Result;

/**
 * Created by github.com/adip28 on 7/17/2018.
 */
public class Prefs {
    private static Prefs mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME = "Auth";

    private static final String KEY_USER_ID = "id";
    private static final String PREF_NAMA = "nama";
    private static final String PREF_USERNAME = "username";

    public Prefs(Context context) {
        mCtx = context;
    }

    public static synchronized Prefs getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new Prefs(context);
        }
        return mInstance;
    }

    public boolean setProfile(Result user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PREF_NAMA, user.getNama());
        editor.putString(PREF_USERNAME, user.getUsername());
        editor.apply();
        return true;
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if (sharedPreferences.getString(PREF_USERNAME, null) != null)
            return true;
        return false;
    }

    public Result getProfile() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Result(
                sharedPreferences.getString(PREF_NAMA, null),
                sharedPreferences.getString(PREF_USERNAME, null)
        );
    }

    public boolean logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }
}
