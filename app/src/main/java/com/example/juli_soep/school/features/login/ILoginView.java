package com.example.juli_soep.school.features.login;

import com.example.juli_soep.school.features.login.model.LoginResponse;

/**
 * Created by github.com/adip28 on 7/17/2018.
 */
public interface ILoginView {
    void initViews();

    void showLoadingIndicator();

    void hideLoadingIndicator();

    void goToDashboard();

    void signIn();

    void onSigninSuccess(LoginResponse response);

    void onRequestFailed(String rm);

    void onNetworkFailed(String cause);
}
