package com.example.infs3605;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.infs3605.Entities.SavedEventData;

@Database(entities = {SavedEventData.class},version = 1, exportSchema = false)
public abstract class SavedEventDatabase extends RoomDatabase {

    public abstract SavedEventDataDao savedEventDataDao();

}
