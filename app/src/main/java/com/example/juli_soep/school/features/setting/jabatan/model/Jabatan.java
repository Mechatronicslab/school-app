package com.example.juli_soep.school.features.setting.jabatan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Jabatan {


    @SerializedName("kode_jabatan")
    @Expose
    private String kd_jabatan;

    @SerializedName("nama_jabatan")
    @Expose
    private String nama_jabatan;

    @SerializedName("golongan")
    @Expose
    private String golongan;

    @SerializedName("gaji")
    @Expose
    private String gaji;

    @SerializedName("tunjangan")
    @Expose
    private String tunjangan;

    @SerializedName("keterangan")
    @Expose
    private String keterangan;



    public String getKdJabatan() {
        return kd_jabatan;
    }

    public void setKdJabatan(String kd_jabatan) {
        this.kd_jabatan = kd_jabatan;
    }

    public String getNamaJabatan() {
        return nama_jabatan;
    }

    public void setNamaJabatan(String nama_jabatan) {
        this.nama_jabatan = nama_jabatan;
    }

    public String getGolongan() {
        return golongan;
    }

    public void setGolongan(String golongan) {
        this.golongan = golongan;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    public String getTunjangan() {
        return tunjangan;
    }

    public void setTunjangan(String tunjangan) {
        this.tunjangan = tunjangan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }



}
