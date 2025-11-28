package com.usrmdk.arquitecturamvvm.model;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;

@Entity(primaryKeys = {"login"})
public class User {
    @SerializedName("login")
    public final String login;
    @SerializedName("avatar_url")
    public  final String avatarUrl;

    @SerializedName("name")
    public  final String name;

    @SerializedName("company")
    public final String company;

    @SerializedName("repos_url")
    public  final  String repoUrl;

    @SerializedName("blog")
    public final  String blog;

    public User(String login, String avatarUrl, String name, String company, String repoUrl, String blog) {
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.name = name;
        this.company = company;
        this.repoUrl = repoUrl;
        this.blog = blog;

    }




}
