package com.techprimers.elastic.standaloneelasticexample.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String id;
    private String name;
    private Date createdOn;
    private Map<String, String> userSettings = new HashMap<>();

    public User() { }

    public User(String id, String name, Date createdOn, Map<String, String> userSettings) {
        this.id = id;
        this.name = name;
        this.createdOn = createdOn;
        this.userSettings = userSettings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Map<String, String> getUserSettings() {
        return userSettings;
    }

    public void setUserSettings(Map<String, String> userSettings) {
        this.userSettings = userSettings;
    }
}
