package com.example.juli_soep.school.features.login;

import android.util.Log;

import com.example.juli_soep.school.App;
import com.example.juli_soep.school.Prefs;
import com.example.juli_soep.school.Prefs2;
import com.example.juli_soep.school.features.login.model.LoginResponse;
import com.example.juli_soep.school.network.NetworkService;
import com.example.juli_soep.school.network.RestService;

import java.util.HashMap;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;



/**
 * Created by github.com/adip28 on 7/17/2018.
 */
public class LoginPresenter {
    final ILoginView view ;
    private final Retrofit restService;
    private final String TAG = "Auth Presenter";

    public LoginPresenter(ILoginView view) {
        this.view = view;
        restService = RestService.getRetroftInstance();
    }

    boolean isLoggedIn(){
        return App.getPref().getBoolean(Prefs2.PREF_IS_LOGEDIN, false);
    }
    void storeProfile(String data){
        App.getPref().put(Prefs2.PREF_STORE_PROFILE, data);
        App.getPref().put(Prefs2.PREF_IS_LOGEDIN, true);
    }

    void login(String username, String password){
        HashMap<String,Object> params = new HashMap<>();
        params.put("tag","login");
        params.put("username",username);
        params.put("password", password);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(chain -> {

            Request original = chain.request();
            Request request = original.newBuilder()
                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(request);
        }).build();
        view.showLoadingIndicator();
        restService.newBuilder().client(okHttpClient).build().create(NetworkService.class).login(params).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, retrofit2.Response<LoginResponse> response) {
                view.hideLoadingIndicator();
                if(response.body().getSuccess()) {
                    //Prefs.getInstance(getApplicationContext()).setProfile(response.body().getResult());
                    App.getPref().put(Prefs2.PREF_IS_LOGEDIN, true);
                    //App.getPref().put(Prefs2.PREF_USERNAME, response.body().getResult().getUsername());
                    view.onSigninSuccess(response.body());
                } else {
                    view.onRequestFailed(response.body().getRm());
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getMessage());
                view.onNetworkFailed(t.getLocalizedMessage());
            }
        });
    }
}
