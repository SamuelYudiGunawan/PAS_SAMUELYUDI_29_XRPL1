package com.example.pas_29_10rpl1;

import java.io.Serializable;

public class Model implements Serializable {
    private String judul;
    private int gambar;

    public Model(String judul, int gambar) {
        this.judul = judul;
        this.gambar = gambar;
    }

    public String getJudul() {
        return judul;
    }

    public int getGambar() {
        return gambar;
    }
}
