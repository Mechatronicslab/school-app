package com.example.juli_soep.school.features.setting_menu.in_periode;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.juli_soep.school.R;
import com.example.juli_soep.school.features.setting_menu.Periode;

import java.util.Calendar;

public class EditPeriode extends AppCompatActivity {

    Button btn_selesai, btn_mulai;
    EditText edt_selesai, edt_mulai;
    DatePickerDialog datePicker;
    int d,m,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_periode);

        btn_selesai = (Button)findViewById(R.id.btn_date_selesai);
        btn_mulai = (Button)findViewById(R.id.btn_date_mulai);

        edt_selesai = (EditText)findViewById(R.id.edt_date_selesai);
        edt_mulai = (EditText)findViewById(R.id.edt_date_mulai);

        btn_mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                d = calendar.get(Calendar.DAY_OF_MONTH);
                m = calendar.get(Calendar.MONTH);
                y = calendar.get(Calendar.YEAR);
                datePicker = new DatePickerDialog(EditPeriode.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        edt_mulai.setText(i2+"/"+i1+"/"+i);
                    }
                }, y, m, d);
                datePicker.show();
            }
        });

        btn_selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                d = calendar.get(Calendar.DAY_OF_MONTH);
                m = calendar.get(Calendar.MONTH);
                y = calendar.get(Calendar.YEAR);
                datePicker = new DatePickerDialog(EditPeriode.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        edt_selesai.setText(i2+"/"+i1+"/"+i);
                    }
                }, y, m, d);
                datePicker.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent kembali = new Intent(EditPeriode.this, Periode.class);
        startActivity(kembali);
        finish();
    }
}
