package com.example.juli_soep.school.setting_menu;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.juli_soep.school.R;
import com.example.juli_soep.school.main_menu.Setting;
import com.example.juli_soep.school.setting_menu.in_periode.EditPeriode;

public class Periode extends AppCompatActivity {

    LinearLayout btn_edit;
    boolean doubleTap = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periode);

        btn_edit = (LinearLayout)findViewById(R.id.list_periode);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (doubleTap) {
                    Intent edit_periode = new Intent(Periode.this, EditPeriode.class);
                    startActivity(edit_periode);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Tekan Sekali Lagi Untuk Mengubah Data", Toast.LENGTH_LONG).show();
                    doubleTap = true;
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            doubleTap = false;
                        }
                    }, 2000);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent kembali = new Intent(Periode.this, Setting.class);
        startActivity(kembali);
        finish();
    }
}
