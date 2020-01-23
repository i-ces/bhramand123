package com.example.bhramand123.Fragments.models;

import java.util.List;

public class Post {
    private String name;
    private String place;
    private List<String> imageUrl;

    public Post(String name, String place, List<String> imageUrl) {
        this.name = name;
        this.place = place;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }
}
