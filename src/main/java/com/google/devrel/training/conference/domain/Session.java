package com.google.devrel.training.conference.domain;

import com.google.devrel.training.conference.form.SessionForm;
import com.google.devrel.training.conference.form.SessionForm.SessionType;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

import java.util.Date;

import static com.google.devrel.training.conference.form.SessionForm.SessionType.General;


/**
 * Created by Mitsos on 13/11/16.
 */
@Entity
public class Session {

    //The id of the session
    @Id private long id;

    //The name of the session
    @Index
    private String name;

    //The key of the parent conference
    @Parent
    private Key<Conference> conferenceKey;

    //The speaker of the session
    @Index
    private String speaker;

    //The start date of the session
    private Date startDate;

    //The start time of the session
    private Date startTime;

    //The duration of the session
    private float duration;

    //The type of session
    @Index
    private SessionType typeOfSession;

    // Get a String version of the key
    public String getWebsafeSessionKey() {
        return Key.create(conferenceKey, Session.class, id).getString();
    }


    public Session() {
    }

    public Session(final long id, String webSafeConferenceKey, final SessionForm sessionForm) {
        this.id = id;
        this.conferenceKey = Key.create(webSafeConferenceKey);
        updateWithConferenceSessionForm(sessionForm);
    }

    public void updateWithConferenceSessionForm(SessionForm sessionForm)
    {
        this.duration = sessionForm.getDuration();
        this.name = sessionForm.getName();
        this.speaker = sessionForm.getSpeaker();
        this.typeOfSession = sessionForm.getTypeOfSession() == null ? General : sessionForm.getTypeOfSession();
        this.startDate = sessionForm.getStartDate();
        this.startTime = sessionForm.getStartTime();
    }

    public String getName() {
        return name;
    }

    public String getSpeaker() {
        return speaker;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public float getDuration() {
        return duration;
    }

    public SessionType getTypeOfSession() {
        return typeOfSession;
    }
}
