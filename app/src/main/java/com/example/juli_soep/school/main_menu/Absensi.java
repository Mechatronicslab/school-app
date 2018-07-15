package com.example.juli_soep.school.main_menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.juli_soep.school.R;

public class Absensi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi);
    }

    @Override
    public void onBackPressed() {
        Intent kembali = new Intent(Absensi.this, MainActivity.class);
        startActivity(kembali);
        finish();
    }
}
