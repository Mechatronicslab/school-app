package com.example.juli_soep.school.features.setting.jabatan;

import android.util.Log;

import com.example.juli_soep.school.features.setting.jabatan.model.Jabatan;
import com.example.juli_soep.school.network.NetworkService;
import com.example.juli_soep.school.network.RestService;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class JabatanPresenter {
    private final String TAG = "Jabatan Presenter";
    private final IjabatanView view;
    private final Retrofit restService;

    public JabatanPresenter(IjabatanView view) {
        this.view = view;
        restService = RestService.getRetroftInstance();
    }


    void getJabatan(){
        HashMap<String,Object> params = new HashMap<>();
        params.put("tag","getJabatan");

        view.showLoadingIndicator();
        restService.newBuilder().client(RestService.getClient()).build().create(NetworkService.class).getJabatan(params)
                .enqueue(new Callback<List<Jabatan>>(){
            @Override
            public void onResponse(Call<List<Jabatan>> call, Response<List<Jabatan>> response) {
                view.hideLoadingIndicator();
                view.onDataReady(response.body());
            }
            @Override
            public void onFailure(Call<List<Jabatan>> call, Throwable t) {
                view.hideLoadingIndicator();
                view.onNetworkFailed();
            }
        });
    }
}
