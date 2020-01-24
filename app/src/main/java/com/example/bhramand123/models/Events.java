package com.example.bhramand123.models;

public class Events {
   private String eventname;
   private String eventdesc;
   private String eventdate;
   private String eventplace;
   private Double eventlatt;
   private Double eventlong;
   private String userid;
   private String imageurl;



    public Events(String eventname, String eventdesc, String eventdate, String eventplace, Double eventlatt, Double eventlong, String userid, String imageurl) {
        this.eventname = eventname;
        this.eventdesc = eventdesc;
        this.eventdate = eventdate;
        this.eventplace = eventplace;
        this.eventlatt = eventlatt;
        this.eventlong = eventlong;
        this.userid = userid;
        this.imageurl = imageurl;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getEventdesc() {
        return eventdesc;
    }

    public void setEventdesc(String eventdesc) {
        this.eventdesc = eventdesc;
    }

    public String getEventdate() {
        return eventdate;
    }

    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }

    public String getEventplace() {
        return eventplace;
    }

    public void setEventplace(String eventplace) {
        this.eventplace = eventplace;
    }

    public Double getEventlatt() {
        return eventlatt;
    }

    public void setEventlatt(Double eventlatt) {
        this.eventlatt = eventlatt;
    }

    public Double getEventlong() {
        return eventlong;
    }

    public void setEventlong(Double eventlong) {
        this.eventlong = eventlong;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
