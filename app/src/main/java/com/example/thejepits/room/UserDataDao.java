package com.example.thejepits.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDataDao {
    @Query("SELECT * FROM userdata WHERE nama= :nama and alamat = :alamat")
    UserData getData(String nama, String alamat);
    @Insert
    void insertAllData(UserData userData);
    @Update
    void update(UserData userData);
}
