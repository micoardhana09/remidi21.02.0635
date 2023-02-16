package com.example.thejepits.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface AkunDao {

    @Query("SELECT * FROM akun WHERE email= :email and password= :password")
    Akun getUser(String email, String password);

    @Query("SELECT * FROM akun WHERE email= :email")
    Akun getRecovery(String email);

    @Insert
    void insertAll(Akun akun);

    @Update
    void update(Akun akun);

}
