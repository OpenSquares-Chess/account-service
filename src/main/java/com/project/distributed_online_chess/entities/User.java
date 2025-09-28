package com.project.distributed_online_chess.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String username;
    private String profileImage;
    private String subId;

    public User() {
    }

    public User(String id, String username, String profileImage, String subId) {
        this.id = id;
        this.username = username;
        this.profileImage = profileImage;
        this.subId = subId;
    }

    public String getId() {
        return id;
    }

    public void setId(String uuid) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }
}
