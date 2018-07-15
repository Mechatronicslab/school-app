package com.example.juli_soep.school.setting_menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.juli_soep.school.R;
import com.example.juli_soep.school.main_menu.Setting;

public class Kelas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelas);
    }

    @Override
    public void onBackPressed() {
        Intent kembali = new Intent(Kelas.this, Setting.class);
        startActivity(kembali);
        finish();
    }
}
