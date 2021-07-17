package com.example.infs3605.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;

@Entity (primaryKeys = {"email","eventId"})
public class SavedEventData {

    @NonNull
    private String email;

    @NonNull
    private int eventId;

    @ColumnInfo
    private String eventImage;

    @ColumnInfo
    private String eventName;

    @ColumnInfo
    private String eventDate;

    @ColumnInfo
    private String eventLink;

    @ColumnInfo
    private String eventDesc;

    @Ignore
    public SavedEventData() {}

    public SavedEventData(@NonNull String email, int eventId, String eventImage, String eventName, String eventDate, String eventLink, String eventDesc) {
        this.email = email;
        this.eventId = eventId;
        this.eventImage = eventImage;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLink = eventLink;
        this.eventDesc = eventDesc;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLink() {
        return eventLink;
    }

    public void setEventLink(String eventLink) {
        this.eventLink = eventLink;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }
}
