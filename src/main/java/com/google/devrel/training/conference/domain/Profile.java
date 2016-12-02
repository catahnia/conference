package com.google.devrel.training.conference.domain;

import com.google.appengine.repackaged.com.google.common.collect.ImmutableList;
import com.google.devrel.training.conference.form.ProfileForm.Gender;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.ArrayList;
import java.util.List;


// TODO indicate that this class is an Entity
@Entity
@Cache
public class Profile {
	String displayName;
	String mainEmail;
	Gender gender;
	// TODO indicate that the userId is to be used in the Entity's key
	@Id String userId;
    
    /**
     * Public constructor for Profile.
     * @param userId The user id, obtained from the email
     * @param displayName Any string user wants us to display him/her on this system.
     * @param mainEmail User's main e-mail address.
     * @param gender The User's gender
     * 
     */
    public Profile (String userId, String displayName, String mainEmail, Gender gender) {
    	this.userId = userId;
    	this.displayName = displayName;
    	this.mainEmail = mainEmail;
    	this.gender = gender;
    }
    
	public String getDisplayName() {
		return displayName;
	}

	public String getMainEmail() {
		return mainEmail;
	}

	public Gender getGender() {
		return gender;
	}

	public String getUserId() {
		return userId;
	}

	// List of conferences the user has registered to attend
	private List<String> conferenceKeysToAttend = new ArrayList<>(0);

	//List of session the user has put in his wish list
	private List<String> sessionKeysInWishList = new ArrayList<>(0);

	public List<String> getConferenceKeysToAttend() {
		return ImmutableList.copyOf(conferenceKeysToAttend);
	}

	public List<String> getSessionKeysInWishList() { return ImmutableList.copyOf(sessionKeysInWishList); }

	public void addToConferenceKeysToAttend(String conferenceKey) {
		conferenceKeysToAttend.add(conferenceKey);
	}

	public void addToSessionKeysInWishList(String sessionKey) { sessionKeysInWishList.add(sessionKey); }

	/**
	 * Remove the conferenceId from conferenceIdsToAttend.
	 *
	 * @param conferenceKey a websafe String representation of the Conference Key.
	 */
	public void unregisterFromConference(String conferenceKey) {
		if (conferenceKeysToAttend.contains(conferenceKey)) {
			conferenceKeysToAttend.remove(conferenceKey);
		} else {
			throw new IllegalArgumentException("Invalid conferenceKey: " + conferenceKey);
		}
	}

	public void removeFromWishList(String sessionKey) {
		if (sessionKeysInWishList.contains(sessionKey)) {
			sessionKeysInWishList.remove(sessionKey);
		} else {
			throw new IllegalArgumentException("Invalid sessionKey: " + sessionKey);
		}

	}


	/**
     * Just making the default constructor private.
     */
    private Profile() {}

	public void update(String displayName, Gender gender){

        if(displayName!=null){
			this.displayName = displayName;
		}

        if(gender!=null){
			this.gender = gender;
		}
	}

}
