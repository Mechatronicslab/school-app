package com.example.juli_soep.school.features.setting.periode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.juli_soep.school.R;
import com.example.juli_soep.school.features.main_menu.MainActivity;
import com.example.juli_soep.school.features.setting.Setting;
import com.example.juli_soep.school.features.setting.jabatan.JabatanAdapter;
import com.example.juli_soep.school.features.setting.jabatan.JabatanPresenter;
import com.example.juli_soep.school.features.setting.jabatan.model.Jabatan;
import com.example.juli_soep.school.features.setting.periode.model.Periode;
import com.example.juli_soep.school.ui.SweetDialogs;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PeriodeActivity extends AppCompatActivity implements IPeriodeView, PeriodeAdapter.OnItemSelected {

    LinearLayout btn_edit;
    boolean doubleTap = false;
    private final String TAG = "Periode Activity";
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.loading_layout)
    RelativeLayout mLoadingIndicator;
    private PeriodePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periode);
        ButterKnife.bind(this);
        presenter = new PeriodePresenter(this);
        initView();
        presenter.getPeriode();

    }


    @Override
    public void initView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.clearFocus();
    }

    @Override
    public void onDataReady(List<Periode> periodes) {
        String data1 = new Gson().toJson(periodes);
        Log.d("Data :", data1);
        PeriodeAdapter adapter = new PeriodeAdapter(periodes, this);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onRequestFailed(String rm) {
        Log.e(TAG, rm);
        SweetDialogs.commonWarning(this, "Gagal memuat permintaan",
                rm, false);
    }

    @Override
    public void onNetworkFailed() {
        //Log.e(TAG);
        SweetDialogs.endpointError(this);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Setting.class));
        finish();
    }


    @Override
    public void onSelect(Periode model) {
        Toast.makeText(this, model.getKdPeriode(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoadingIndicator() {
        mLoadingIndicator.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingIndicator() {
        mLoadingIndicator.setVisibility(View.GONE);
    }

}
