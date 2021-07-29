package com.example.infs3605;

import android.accounts.Account;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.infs3605.Entities.AccountAchievement;
import com.example.infs3605.Entities.ProfileData;
import com.example.infs3605.Entities.SavedEventData;

//this database class defines all the entities we used with a Room DB
@Database(entities = {ProfileData.class, AccountAchievement.class}, version = 2, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {

    public abstract ProfileDataDao profileDataDao();

    public abstract AccountAchievementDao accountAchievementDao();



}
