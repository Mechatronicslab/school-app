package com.example.juli_soep.school.features.setting.jurusan;

import com.example.juli_soep.school.features.setting.jurusan.model.Jurusan;

import java.util.List;

public interface IJurusanView {
    void initView();



    void onDataReady(List<Jurusan> jurusans);

    void onRequestFailed(String rm);


    void onNetworkFailed();

    void showLoadingIndicator();

    void hideLoadingIndicator();
}
