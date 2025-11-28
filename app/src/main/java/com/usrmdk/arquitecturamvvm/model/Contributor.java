package com.usrmdk.arquitecturamvvm.model;


import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(primaryKeys = {"repoName", "repoOwner", "login"}, foreignKeys = @ForeignKey(entity = Repo.class,
        parentColumns = {"name", "owner_login"}, childColumns = {"repoName", "repoOwner"}, onUpdate = ForeignKey.CASCADE))

public class Contributor {

    public final String login;
    public final int contributions;
    public final String avatarUrl;

    public String repoName;
    public String repoOwner;

    public Contributor(String login, int contributions, String avatarUrl) {
        this.login = login;
        this.contributions = contributions;
        this.avatarUrl = avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public int getContributions() {
        return contributions;

    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getRepoName() {
        return repoName;
    }

    public String getRepoOwner() {
        return repoOwner;
    }

}
