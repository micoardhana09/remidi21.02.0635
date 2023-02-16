package com.example.thejepits.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Akun.class}, version = 1, exportSchema = false)
public abstract class RecoveryDatabase extends RoomDatabase {
    public abstract AkunDao getRecovery();
}
