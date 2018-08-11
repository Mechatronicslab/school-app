package com.example.juli_soep.school.features.main_menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.juli_soep.school.App;
import com.example.juli_soep.school.Prefs2;
import com.example.juli_soep.school.R;
import com.example.juli_soep.school.features.login.Login;
import com.example.juli_soep.school.features.login.model.LoginResponse;
import com.example.juli_soep.school.features.setting.Setting;
import com.example.juli_soep.school.util.GsonHelper;

public class MainActivity extends AppCompatActivity {

    LinearLayout btn_setting, btn_about, btn_absensi, btn_anggota, btn_pembayaran,btn_logout;
    Prefs2 session;
    private LoginResponse mProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = new Prefs2(this);
        mProfile = (LoginResponse) GsonHelper.parseGson(
                App.getPref().getString(Prefs2.PREF_STORE_PROFILE, ""),
                new LoginResponse()
        );
        String name = (mProfile.getResult().getNama().contains(" "))
                ? mProfile.getResult().getNama().split(" ")[3] : mProfile.getResult().getNama();
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
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

        btn_logout = (LinearLayout)findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });


    }
    private void logout() {
        App.getPref().clear();

        startActivity(new Intent(this, Login.class));
        finish();
    }
}
