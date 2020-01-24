package com.example.bhramand123.models;

public class Events {
    private String date;
    private String heading;
    private String eventsDescription;
    private String publisherId;



    public Events(String date, String heading, String eventsDescription, String publisherId) {
        this.date = date;
        this.heading = heading;
        this.eventsDescription = eventsDescription;
        this.publisherId=publisherId;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getEventsDescription() {
        return eventsDescription;
    }

    public void setEventsDescription(String eventsDescription) {
        this.eventsDescription = eventsDescription;
    }
    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }
}
