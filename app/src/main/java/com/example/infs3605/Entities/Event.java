package com.example.infs3605.Entities;

import com.example.infs3605.R;

import java.util.ArrayList;

public class Event {

    private int eventImage;
    private String eventName;
    private String eventDate;
    private boolean attending;

    public Event (int eventImage, String eventName, String eventDate) {
        this.eventImage = eventImage;
        this.eventName = eventName;
        this.eventDate = eventDate;
        attending = false;
    }

    public int getEventImage() {
        return eventImage;
    }

    public void setEventImage(int eventImage) {
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

    public boolean getAttending() {
        return attending;
    }

    public void setAttending(boolean attending) {
        this.attending = attending;
    }

    public static ArrayList<Event> getEventList() {
        ArrayList<Event> eventList = new ArrayList<>();

        eventList.add(new Event(R.drawable.event1,"National Aboriginal and Torres Strait Islander Children's Day","4 Aug 2021"));
        eventList.add(new Event(R.drawable.event2,"National Indigenous Music Awards","7 Aug 2021"));
        eventList.add(new Event(R.drawable.event3,"Piinpi: Contemporary Indigenous Fashion","20 Feb 2022"));
        eventList.add(new Event(R.drawable.event4, "Darwin Aboriginal Art Fair","6 Aug 2022"));
        eventList.add((new Event(R.drawable.event5,"Indigenous Literacy Day","1 Sep 2021")));

        return eventList;
    }


}

