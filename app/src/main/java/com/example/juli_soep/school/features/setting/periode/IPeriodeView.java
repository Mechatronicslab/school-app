package com.example.juli_soep.school.features.setting.periode;

import com.example.juli_soep.school.features.setting.periode.model.Periode;

import java.util.List;

public interface IPeriodeView {
    void initView();

    void onDataReady(List<Periode> periodes);

    void onRequestFailed(String rm);

    void onNetworkFailed();

    void onSelect(Periode model);

    void showLoadingIndicator();

    void hideLoadingIndicator();
}
