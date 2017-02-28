package com.wuruihong.jetbrains.gitCommitterSwitch;

import java.util.UUID;

/**
 * Created by hans on 2017/2/10.
 */
public class User {
    private String uuid;
    private String name;
    private String email;
    private String comment;
    private boolean selected;

    public User() {
        this.setUuid(UUID.randomUUID().toString());
    }

    public User(String name, String email) {
        this();
        this.setName(name);
        this.setEmail(email);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
