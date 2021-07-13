package com.example.infs3605;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.infs3605.Entities.ProfileData;

//this database class defines all the entities wee used with a Room DB
@Database(entities = {ProfileData.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {

    public abstract ProfileDataDao profileDataDao();

}
