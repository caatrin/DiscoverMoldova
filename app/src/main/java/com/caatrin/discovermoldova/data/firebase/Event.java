package com.caatrin.discovermoldova.data.firebase;

/**
 * Created by ecaterinagaleru on 2/11/16.
 */
public class Event {

    private String name;
    private Time time;
    private Location location;
    private String tickets;
    private String description;
    private String imageUrl;
    private int phoneNumber;

    public Event() {
    }

    public String getName() {
        return name;
    }

    public Time getTime() {
        return time;
    }

    public Location getLocation() {
        return location;
    }

    public String getTickets() {
        return tickets;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

}
