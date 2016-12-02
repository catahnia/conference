package com.google.devrel.training.conference.domain;

/**
 * Created by Mitsos on 11/11/16.
 */
public class Announcement {
    private String message;

    public Announcement() {
    }

    public Announcement(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
