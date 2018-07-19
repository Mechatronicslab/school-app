package com.example.juli_soep.school.features.login.model;

/**
 * Created by github.com/adip28 on 7/18/2018.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
public class Result {
    @SerializedName("password")
    private String mPassword;
    @SerializedName("nama")
    private String mNama;
    @SerializedName("username")
    private String mUsername;

    public Result(String name, String username) {
        this.mNama = name;
        this.mUsername = username;

    }
    public String getNama() {
        return mNama;
    }

    public void setNama(String nama) {
        mNama = nama;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
}
