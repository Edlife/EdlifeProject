package com.example.edlifepersonal.models;

import android.net.Uri;

import java.util.ArrayList;

public class Users {
    String userName,mail,password,userId,program,school,degree,profilePicUri,gender;
    ArrayList interests;

    public Users(String userName, String mail, String password,String program, String school,String degree, ArrayList interests,String profilePicUri,String gender) {
        this.userName = userName;
        this.mail = mail;
        this.password = password;
        this.program = program;
        this.school = school;
        this.degree = degree;
        this.interests = interests;
        this.profilePicUri = profilePicUri;
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String School) {
        this.school = school;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public ArrayList getInterests() {
        return interests;
    }

    public void setInterests(ArrayList interests) {
        this.interests = interests;
    }

    public String getProfilePicUri() {
        return profilePicUri;
    }

    public void setProfilePicUri(String profilePicUri) {
        this.profilePicUri = profilePicUri;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
