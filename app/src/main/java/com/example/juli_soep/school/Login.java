package com.example.juli_soep.school;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Login extends AppCompatActivity {

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
    }
}
