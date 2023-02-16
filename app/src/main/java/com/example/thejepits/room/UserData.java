package com.example.thejepits.room;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class UserData implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    int id;

    String nama;
    String alamat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public UserData(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }
}
