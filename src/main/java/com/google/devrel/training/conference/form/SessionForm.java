package com.google.devrel.training.conference.form;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Mitsos on 17/11/16.
 */
public class SessionForm {

    private String name;

    private String speaker;

    private float duration;

    private SessionType typeOfSession;

    private Date startDate;

    private Date startTime;

    public SessionForm() {
    }

    public SessionForm(String name, String speaker, float duration, SessionType typeOfSession, Date startDate, Date startTime)
        throws ParseException{
        this.name = name ;
        this.speaker = speaker;
        this.duration = duration;
        this.typeOfSession = typeOfSession ;
        this.startDate = startDate == null ? null : new Date(startDate.getTime());
        this.startTime = startTime == null ? null : new Date(startTime.getTime());
    }

    public String getName() {
        return name;
    }

    public String getSpeaker() {
        return speaker;
    }

    public float getDuration() {
        return duration;
    }

    public SessionType getTypeOfSession() {
        return typeOfSession;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public static enum SessionType {
        General,
        Worskshop,
        Lecture,
        Keynote

    }
}
