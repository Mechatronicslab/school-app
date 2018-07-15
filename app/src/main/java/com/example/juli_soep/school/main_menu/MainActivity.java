package com.example.juli_soep.school.main_menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.juli_soep.school.R;

public class MainActivity extends AppCompatActivity {

    LinearLayout btn_setting, btn_about, btn_absensi, btn_anggota, btn_pembayaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_setting = (LinearLayout)findViewById(R.id.btn_setting);
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent setting = new Intent(MainActivity.this, Setting.class);
                startActivity(setting);
                finish();
            }
        });

        btn_absensi = (LinearLayout)findViewById(R.id.btn_absensi);
        btn_absensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent absensi = new Intent(MainActivity.this, Absensi.class);
                startActivity(absensi);
                finish();
            }
        });

        btn_anggota = (LinearLayout)findViewById(R.id.btn_anggota);
        btn_anggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anggota = new Intent(MainActivity.this, Anggota.class);
                startActivity(anggota);
                finish();
            }
        });

        btn_pembayaran = (LinearLayout)findViewById(R.id.btn_pembayaran);
        btn_pembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pembayaran = new Intent(MainActivity.this, Pembayaran.class);
                startActivity(pembayaran);
                finish();
            }
        });

        btn_about = (LinearLayout)findViewById(R.id.btn_tentang);
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about = new Intent(MainActivity.this, About.class);
                startActivity(about);
                finish();
            }
        });
    }
}
