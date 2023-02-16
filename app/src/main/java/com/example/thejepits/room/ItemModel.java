package com.example.thejepits.room;

public class ItemModel {

    String judul;
    String pengarang;
    String tahun;
    int cover;
    String isi;


    public ItemModel(String judul, String pengarang, String tahun, int cover, String isi) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahun = tahun;
        this.cover = cover;
        this.isi = isi;
    }

    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public int getCover() {
        return cover;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
}
