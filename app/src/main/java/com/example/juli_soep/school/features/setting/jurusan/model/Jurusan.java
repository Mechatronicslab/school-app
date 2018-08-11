package com.example.juli_soep.school.features.setting.jurusan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;


public class Jurusan {

    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("kode_jurusan")
    @Expose
    private String kd_jurusan;

    @SerializedName("nama_jurusan")
    @Expose
    private String nama_jurusan;

    @SerializedName("keterangan")
    @Expose
    private String keterangan;





    public String getKd_jurusan() {
        return kd_jurusan;
    }

    public void setKd_jurusan(String kd_jurusan) {
        this.kd_jurusan = kd_jurusan;
    }

    public String getNama_jurusan() {
        return nama_jurusan;
    }

    public void setNama_jurusan(String nama_jurusan) {
        this.nama_jurusan = nama_jurusan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Boolean getSuccess() {
        return success;
    }

}
