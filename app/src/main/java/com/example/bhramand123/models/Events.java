package com.example.bhramand123.models;

public class Events {
    private String date;
    private String heading;
    private String eventsDescription;

    public Events(String date, String heading, String eventsDescription) {
        this.date = date;
        this.heading = heading;
        this.eventsDescription = eventsDescription;
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
}
