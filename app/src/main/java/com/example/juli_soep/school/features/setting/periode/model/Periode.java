package com.example.juli_soep.school.features.setting.periode.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Periode {

    @SerializedName("kode_periode")
    @Expose
    private String kd_periode;

    @SerializedName("nama_periode")
    @Expose
    private String nama_periode;

    @SerializedName("tanggal_mulai")
    @Expose
    private String tgl_mulai;

    @SerializedName("tanggal_selesai")
    @Expose
    private String tgl_selesai;

    @SerializedName("keterangan")
    @Expose
    private String keterangan;



    public String getKdPeriode() {
        return kd_periode;
    }

    public void setKdPeriode(String kd_periode) {
        this.kd_periode = kd_periode;
    }

    public String getNamaPeriode() {
        return nama_periode;
    }

    public void setNamaPeriode(String nama_periode) {
        this.nama_periode = nama_periode;
    }

    public String getTglMulai() {
        return tgl_mulai;
    }

    public void setTglMulai(String tgl_mulai) {
        this.tgl_mulai = tgl_mulai;
    }

    public String getTglSelesai() {
        return tgl_selesai;
    }

    public void setTglSelesai(String tgl_selesai) {
        this.tgl_selesai = tgl_selesai;
    }


    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

}
