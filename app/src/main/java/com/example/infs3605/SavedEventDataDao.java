package com.example.infs3605;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Update;

import com.example.infs3605.Entities.SavedEventData;

import java.util.List;

@Dao
public interface SavedEventDataDao {

    @Query("SELECT * FROM SavedEventData")
    List<SavedEventData> getAllSavedEvents();

    @Query("SELECT * FROM SavedEventData WHERE email == :email")
    List<SavedEventData> getUserSavedEvents(String email);

    @Query("SELECT * FROM SavedEventData WHERE email == :email AND eventId == :eventId")
    SavedEventData getSavedEvent(String email, int eventId);

    @Query("INSERT INTO SavedEventData VALUES (:email, :eventId, :eventImage, :eventName, :eventDate, :eventLink, :eventDesc, :eventLoc)")
    void saveEvent(String email, int eventId, String eventImage, String eventName, String eventDate, String eventLink, String eventDesc, String eventLoc);

    @Query("DELETE FROM SavedEventData")
    void deleteAll();

    @Query("DELETE FROM SavedEventData WHERE email == :email AND eventId == :eventId")
    void deleteEvent(String email, int eventId);

    @Update
    void addEvent(SavedEventData savedEvent);

    @Delete
    void removeEvent(SavedEventData savedEvent);


}
