package com.example.juli_soep.school.features.setting_menu.in_jurusan;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.juli_soep.school.R;
import com.example.juli_soep.school.features.setting_menu.Jurusan;

public class EditJurusan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_jurusan);

    }

    @Override
    public void onBackPressed() {
        Intent kembali = new Intent(EditJurusan.this, Jurusan.class);
        startActivity(kembali);
        finish();
    }

    public void showSoftKeyboard(View view) {
        if (view.requestFocus()) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }

}
