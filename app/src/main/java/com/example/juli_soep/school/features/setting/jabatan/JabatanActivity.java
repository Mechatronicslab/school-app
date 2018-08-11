package com.example.juli_soep.school.features.setting.jabatan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.juli_soep.school.R;
import com.example.juli_soep.school.features.main_menu.MainActivity;
import com.example.juli_soep.school.features.setting.Setting;
import com.example.juli_soep.school.features.setting.jabatan.model.Jabatan;
import com.example.juli_soep.school.features.setting.jurusan.JurusanActivity;
import com.example.juli_soep.school.features.setting.jurusan.JurusanAdapter;
import com.example.juli_soep.school.features.setting.jurusan.JurusanPresenter;
import com.example.juli_soep.school.features.setting.jurusan.model.Jurusan;
import com.example.juli_soep.school.ui.SweetDialogs;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JabatanActivity extends AppCompatActivity implements IjabatanView, JabatanAdapter.OnItemSelected  {
    private final String TAG = "Jabatan Activity";
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private JabatanPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jabatan);
        ButterKnife.bind(this);
        presenter = new JabatanPresenter(this);
        presenter.getJabatan();
        initView();

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
    public void onDataReady(List<Jabatan> jabatans) {
        String data1 = new Gson().toJson(jabatans);
        Log.d("Data :", data1);
        JabatanAdapter adapter = new JabatanAdapter(jabatans, this);
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
    public void onSelect(Jabatan model) {
        Toast.makeText(this, model.getKdJabatan(),Toast.LENGTH_LONG).show();
    }


}
