package com.example.juli_soep.school.features.setting.jabatan;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.juli_soep.school.R;
import com.example.juli_soep.school.features.setting.Setting;
import com.example.juli_soep.school.features.setting_menu.in_jabatan.EditJabatan;

public class Jabatan extends AppCompatActivity {

    LinearLayout edit_jabatan;
    boolean doubleTap = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jabatan);

        edit_jabatan = (LinearLayout)findViewById(R.id.list_jabatan);
        edit_jabatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (doubleTap){
                    Intent edit_jabatan = new Intent(Jabatan.this, EditJabatan.class);
                    startActivity(edit_jabatan);
                    finish();
                }else {
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
        Intent kembali = new Intent(Jabatan.this, Setting.class);
        startActivity(kembali);
        finish();
    }


}
