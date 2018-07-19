package com.example.juli_soep.school.features.login.model;

/**
 * Created by github.com/adip28 on 7/17/2018.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
public class LoginResponse {

    @SerializedName("result")
    private Result mResult;
    @SerializedName("msg")
    private String mRm;
    @SerializedName("success")
    private Boolean mSuccess;


    public String getRm() {
        return mRm;
    }

    public void setRm(String rm) {
        mRm = rm;
    }

    public Boolean getSuccess() {
        return mSuccess;
    }

    public void setSuccess(Boolean success) {
        mSuccess = success;
    }

    public Result getResult() {
        return mResult;
    }

    public void setResult(Result result) {
        mResult = result;
    }

}
