package com.example.juli_soep.school.main_menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.juli_soep.school.setting_menu.Jabatan;
import com.example.juli_soep.school.setting_menu.Jurusan;
import com.example.juli_soep.school.setting_menu.Kelas;
import com.example.juli_soep.school.setting_menu.Pelajaran;
import com.example.juli_soep.school.setting_menu.Periode;
import com.example.juli_soep.school.setting_menu.Profile;
import com.example.juli_soep.school.R;

public class Setting extends AppCompatActivity {

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
