package com.example.thejepits.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserData.class}, version = 1, exportSchema = false)
public abstract class DataDatabase extends RoomDatabase {
    public abstract UserDataDao getDataDao();
}
