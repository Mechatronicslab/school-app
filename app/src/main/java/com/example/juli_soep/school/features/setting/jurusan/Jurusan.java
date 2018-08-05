package com.example.juli_soep.school.features.setting.jurusan;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.juli_soep.school.R;
import com.example.juli_soep.school.features.setting.Setting;
import com.example.juli_soep.school.features.setting_menu.in_jurusan.EditJurusan;

public class Jurusan extends AppCompatActivity {

    LinearLayout btn_edit;
    boolean doubleTap = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jurusan);

        btn_edit = (LinearLayout)findViewById(R.id.list_jurusan);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (doubleTap){
                    Intent edit_jurusan = new Intent(Jurusan.this, EditJurusan.class);
                    startActivity(edit_jurusan);
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
        Intent kembali = new Intent(Jurusan.this, Setting.class);
        startActivity(kembali);
        finish();
    }
}
