package com.example.juli_soep.school.features.setting.jurusan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.juli_soep.school.R;
import com.example.juli_soep.school.features.main_menu.MainActivity;
import com.example.juli_soep.school.features.setting.Setting;
import com.example.juli_soep.school.features.setting.jurusan.model.Jurusan;
import com.example.juli_soep.school.ui.SweetDialogs;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JurusanActivity extends AppCompatActivity implements IJurusanView,JurusanAdapter.OnItemSelected {
    private final String TAG = "Jurusan Activity";
    LinearLayout btn_edit;
    boolean doubleTap = false;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private JurusanPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jurusan);
        ButterKnife.bind(this);
        presenter = new JurusanPresenter(this);
        presenter.getJurusan();
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
    public void onDataReady(List<Jurusan> jurusans) {
        //JabatanAdapter adapter = new JabatanAdapter(jurusans, this);
        //mRecyclerView.setAdapter(adapter);
        //Log.d(TAG, String.valueOf(jurusans.getResult()));
        String data1 = new Gson().toJson(jurusans);
        Log.d("Data :", data1);

        /*ArrayList<Jabatan> data = new ArrayList<Jabatan>();

            data.add(new Jabatan(
                    jurusans.getKd_jurusan(),
                    jurusans.getNama_jurusan(),
                    jurusans.getKeterangan()

            ));*/

        JurusanAdapter adapter = new JurusanAdapter(jurusans, this);
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
    public void onSelect(Jurusan model) {
        Toast.makeText(this, model.getKd_jurusan(),Toast.LENGTH_LONG).show();
    }
}
