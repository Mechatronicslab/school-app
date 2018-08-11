package com.example.juli_soep.school.features.setting.jabatan;

import com.example.juli_soep.school.features.setting.jabatan.model.Jabatan;

import java.util.List;

public interface IjabatanView {
    void initView();

    void onDataReady(List<Jabatan> jabatans);

    void onRequestFailed(String rm);

    void onNetworkFailed();

    void showLoadingIndicator();

    void hideLoadingIndicator();
}
