package com.example.juli_soep.school.features.setting.pelajaran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.juli_soep.school.R;
import com.example.juli_soep.school.features.setting.Setting;

public class Pelajaran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelajaran);
    }

    @Override
    public void onBackPressed() {
        Intent kembali = new Intent(Pelajaran.this, Setting.class);
        startActivity(kembali);
        finish();
    }
}
