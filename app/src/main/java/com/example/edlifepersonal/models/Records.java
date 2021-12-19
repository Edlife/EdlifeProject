package com.example.edlifepersonal.models;

public class Records {
    private String title;
    private String profilePicUri;
    private String name;
    private String content;
    private String date;
    private String email;
    private String price;
    private String itemPicUri;

    public Records(String title,String profilePicUri,String name,String content,String date,String email,String price,String itemPicUri){
        this.title = title;
        this.profilePicUri = profilePicUri;
        this.name = name;
        this.content = content;
        this.date = date;
        this.email = email;
        this.price = price;
        this.itemPicUri = itemPicUri;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrice(){return price;}

    public void setPrice(String price){this.price = price;}

    public String getItemPicUri(){return itemPicUri;}

    public void setItemPicUri(String itemPicUri){this.itemPicUri = itemPicUri;}
}
