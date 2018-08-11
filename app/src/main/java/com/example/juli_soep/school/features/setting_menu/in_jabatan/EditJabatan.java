package com.example.juli_soep.school.features.setting_menu.in_jabatan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.juli_soep.school.R;
import com.example.juli_soep.school.features.setting.jabatan.JabatanActivity;

import java.util.ArrayList;
import java.util.List;

public class EditJabatan extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_jabatan);

        Spinner spinner = (Spinner) findViewById(R.id.edt_golongan);
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<>();
        categories.add("Golongan A1");
        categories.add("Golongan A2");
        categories.add("Golongan B1");
        categories.add("Golongan B2");
        categories.add("Golongan C1");
        categories.add("Golongan C2");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onBackPressed() {
        Intent kembali = new Intent(EditJabatan.this, JabatanActivity.class);
        startActivity(kembali);
        finish();
    }
}
