package com.example.juli_soep.school.login;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.juli_soep.school.main_menu.MainActivity;
import com.example.juli_soep.school.R;

public class Login extends AppCompatActivity {

    Button btn_login;

    RelativeLayout relay_one, relay_two;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            relay_one.setVisibility(View.VISIBLE);
            relay_two.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        relay_one = (RelativeLayout)findViewById(R.id.rellay_one);
        relay_two = (RelativeLayout)findViewById(R.id.rellay_two);
        handler.postDelayed(runnable, 2000);

        btn_login = (Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(Login.this, MainActivity.class);
                startActivity(login);
                finish();
            }
        });
    }
}
