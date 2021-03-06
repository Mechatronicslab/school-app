package com.example.juli_soep.school.features.setting.jurusan;

import android.util.Log;

import com.example.juli_soep.school.features.setting.jurusan.model.Jurusan;
import com.example.juli_soep.school.network.NetworkService;
import com.example.juli_soep.school.network.RestService;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class JurusanPresenter {
    private final String TAG = "Jabatan Presenter";
    private final IJurusanView view;
    private final Retrofit restService;

    public JurusanPresenter(IJurusanView view) {
        this.view = view;
        restService = RestService.getRetroftInstance();
    }

    void getJurusan(){
        HashMap<String,Object> params = new HashMap<>();
        params.put("tag","getJurusan");

        view.showLoadingIndicator();
        restService.newBuilder().client(RestService.getClient()).build().create(NetworkService.class).getJurusan(params)
                .enqueue(new Callback<List<Jurusan>>(){
            @Override
            public void onResponse(Call<List<Jurusan>> call, Response<List<Jurusan>> response) {
                view.hideLoadingIndicator();
                    view.onDataReady(response.body());
            }
            @Override
            public void onFailure(Call<List<Jurusan>> call, Throwable t) {
                view.hideLoadingIndicator();
                view.onNetworkFailed();
            }
        });
    }
}
