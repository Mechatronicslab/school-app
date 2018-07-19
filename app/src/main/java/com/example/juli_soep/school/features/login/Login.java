package com.example.juli_soep.school.features.login;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.juli_soep.school.Prefs;
import com.example.juli_soep.school.features.login.model.LoginResponse;
import com.example.juli_soep.school.features.main_menu.MainActivity;
import com.example.juli_soep.school.R;
import com.example.juli_soep.school.ui.SweetDialogs;
import com.example.juli_soep.school.ui.TopSnakbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity implements ILoginView,View.OnClickListener {
    private final String TAG = "Login Activity";
    LoginPresenter presenter;
    Prefs session;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            relay_one.setVisibility(View.VISIBLE);
            relay_two.setVisibility(View.VISIBLE);
        }
    };
    @BindView(R.id.btn_login)
    Button mLogin;
    @BindView(R.id.rellay_one)
    RelativeLayout relay_one;
    @BindView(R.id.rellay_two)
    RelativeLayout relay_two;
    @BindView(R.id.edt_username)
    EditText username;
    @BindView(R.id.edt_password)
    EditText password;
    @BindView(R.id.loading_layout)
    RelativeLayout mLoadingIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        handler.postDelayed(runnable, 2000);
        presenter = new LoginPresenter(this);
        session = new Prefs(this);
        if (session.isLoggedIn())
            this.goToDashboard();
        else this.initViews();


    }

    @Override
    public void initViews(){
        mLogin.setOnClickListener(this);
    }

    @Override
    public void showLoadingIndicator() {
        mLoadingIndicator.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingIndicator() {
        mLoadingIndicator.setVisibility(View.GONE);
    }

    @Override
    public void goToDashboard() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void signIn() {
        presenter.login(
                username.getText().toString(),
                password.getText().toString()
        );
    }
    @Override
    public void onSigninSuccess(LoginResponse response) {
        Log.i(TAG, "Login success");
        //session.setProfile(new Gson().toJson(response));
        Prefs.getInstance(getApplicationContext()).setProfile(response.getResult());
        //presenter.storeAccessToken(response.getResult().getAccessToken());
        Toast.makeText(this, "Signin berhasil", Toast.LENGTH_SHORT).show();
        this.goToDashboard();
    }

    @Override
    public void onRequestFailed(String rm) {
        Log.e(TAG, rm);
        SweetDialogs.commonWarning(this, "Gagal memuat permintaan",
                rm, false);
    }

    @Override
    public void onNetworkFailed(String cause) {
        Log.e(TAG, cause);
        SweetDialogs.endpointError(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.btn_login):
            if (username.getText().toString().equals("") || password.getText().toString().equals("")) {
                TopSnakbar.showWarning(this, "Kolom tidak boleh kosong");
            } else this.signIn();
            break ;
        }
    }
}
