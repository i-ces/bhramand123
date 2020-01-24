package com.example.bhramand123.models;

import java.util.List;

public class Post {
    private String name;
    private String district;
   // private List<String> imageUrl;
    String imageUrl ;
    private double lonng;
    private double lattt;
    String desc;
String uid;

    public Post(String name, String district, String imageUrl, double lonng, double lattt, String desc, String uid) {
        this.name = name;
        this.district = district;
        this.imageUrl = imageUrl;
        this.lonng = lonng;
        this.lattt = lattt;
        this.desc = desc;
        this.uid = uid;
    }

  public Post(String name, String district, String imageUrl, String desc, String uid) {
        this.name = name;
        this.district = district;
        this.imageUrl = imageUrl;
        this.desc = desc;
        this.uid = uid;
    }

    public double getLonng() {
        return lonng;
    }

    public void setLonng(double lonng) {
        this.lonng = lonng;
    }

    public double getLattt() {
        return lattt;
    }

    public void setLattt(double lattt) {
        this.lattt = lattt;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Post() {
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }



  /*  public Post(String name, String place, St/*List<String> imageUrl) {
        this.name = name;
        this.place = place;
        this.imageUrl = imageUrl;
    }*/

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


  /*  public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }*/
}
