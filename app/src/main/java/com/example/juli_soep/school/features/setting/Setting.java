package com.example.juli_soep.school.features.setting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.juli_soep.school.features.main_menu.MainActivity;
import com.example.juli_soep.school.features.setting.jabatan.Jabatan;
import com.example.juli_soep.school.features.setting.jurusan.Jurusan;
import com.example.juli_soep.school.features.setting.kelas.Kelas;
import com.example.juli_soep.school.features.setting.pelajaran.Pelajaran;
import com.example.juli_soep.school.features.setting.periode.Periode;
import com.example.juli_soep.school.features.setting.profile.Profile;
import com.example.juli_soep.school.R;
import com.google.android.gms.maps.GoogleMap;

public class Setting extends AppCompatActivity {
    GoogleMap Gmap;
    LinearLayout btn_profile, btn_jurusan, btn_periode, btn_jabatan, btn_pelajaran, btn_kelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        btn_profile = (LinearLayout)findViewById(R.id.btn_profile);
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profile = new Intent(Setting.this, Profile.class);
                startActivity(profile);
                finish();
            }
        });

        btn_pelajaran = (LinearLayout)findViewById(R.id.btn_pelajaran);
        btn_pelajaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pelajaran = new Intent(Setting.this, Pelajaran.class);
                startActivity(pelajaran);
                finish();
            }
        });

        btn_kelas = (LinearLayout)findViewById(R.id.btn_kelas);
        btn_kelas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kelas = new Intent(Setting.this, Kelas.class);
                startActivity(kelas);
                finish();
            }
        });

        btn_jurusan = (LinearLayout)findViewById(R.id.btn_jurusan);
        btn_jurusan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jurusan = new Intent(Setting.this, Jurusan.class);
                startActivity(jurusan);
                finish();
            }
        });

        btn_periode = (LinearLayout)findViewById(R.id.btn_periode);
        btn_periode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent periode = new Intent(Setting.this, Periode.class);
                startActivity(periode);
                finish();
            }
        });

        btn_jabatan = (LinearLayout)findViewById(R.id.btn_jabatan);
        btn_jabatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jabatan = new Intent(Setting.this, Jabatan.class);
                startActivity(jabatan);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent kembali = new Intent(Setting.this, MainActivity.class);
        startActivity(kembali);
        finish();
    }
}
