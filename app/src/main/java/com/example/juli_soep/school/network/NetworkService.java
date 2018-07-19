package com.example.juli_soep.school.network;

import com.example.juli_soep.school.features.login.model.LoginResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by github.com/adip28 on 7/17/2018.
 */
public interface NetworkService {
    @FormUrlEncoded
    @POST("api-school-app/")
    Call<LoginResponse>login(@FieldMap Map<String, Object> params);
}
