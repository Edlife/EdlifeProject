package com.example.edlifepersonal.models;

public class Notes {
    private String title;
    private String profilePicUri;
    private String name;
    private String content;
    private String date;
    private String itemPicUri;
    private String price;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfilePicUri() {
        return profilePicUri;
    }

    public void setProfilePicUri(String profilePicUri) {
        this.profilePicUri = profilePicUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getItemPicUri() {
        return itemPicUri;
    }

    public void setItemPicUri(String itemPicUri) {
        this.itemPicUri = itemPicUri;
    }

    public String getPrice(){return price;}

    public void setPrice(String price){this.price = price;}
}
