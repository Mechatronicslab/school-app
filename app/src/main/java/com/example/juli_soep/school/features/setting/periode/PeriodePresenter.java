package com.example.juli_soep.school.features.setting.periode;

import android.util.Log;

import com.example.juli_soep.school.features.setting.jabatan.model.Jabatan;
import com.example.juli_soep.school.features.setting.periode.model.Periode;
import com.example.juli_soep.school.network.NetworkService;
import com.example.juli_soep.school.network.RestService;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PeriodePresenter {
    private final String TAG = "PeriodePresenter";
    private final IPeriodeView view ;
    private final Retrofit restService;

    public PeriodePresenter(IPeriodeView view) {
        this.view = view;
        this.restService = RestService.getRetroftInstance();
    }

    void getPeriode(){
        HashMap<String,Object> params = new HashMap<>();
        params.put("tag","getPeriode");

        //view.showLoadingIndicator();
        restService.newBuilder().client(RestService.getClient()).build().create(NetworkService.class).getPeriode(params)
                .enqueue(new Callback<List<Periode>>(){
                    @Override
                    public void onResponse(Call<List<Periode>> call, Response<List<Periode>> response) {
                        view.onDataReady(response.body());
                    }
                    @Override
                    public void onFailure(Call<List<Periode>> call, Throwable t) {
                        Log.i(TAG, "onFailure: " + t.getMessage());
                        view.onNetworkFailed();
                    }
                });
    }
}
