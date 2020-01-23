package com.example.bhramand123.models;

public class User {
    private String email,name,phoneno,password;

    public User(String email, String name, String phoneno, String password) {
        this.email = email;
        this.name = name;
        this.phoneno = phoneno;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
