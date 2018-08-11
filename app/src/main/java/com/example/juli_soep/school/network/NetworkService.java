package com.example.juli_soep.school.network;

import com.example.juli_soep.school.features.login.model.LoginResponse;
import com.example.juli_soep.school.features.setting.jabatan.model.Jabatan;
import com.example.juli_soep.school.features.setting.jurusan.model.Jurusan;
import com.example.juli_soep.school.features.setting.periode.model.Periode;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by github.com/adip28 on 7/17/2018.
 */
public interface NetworkService {
    @FormUrlEncoded
    @POST("index.php")
    Call<LoginResponse>login(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST("index.php")
    Call<List<Jurusan>>getJurusan(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST("index.php")
    Call<List<Jabatan>>getJabatan(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST("index.php")
    Call<List<Periode>>getPeriode(@FieldMap Map<String, Object> params);
}
