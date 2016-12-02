package com.google.devrel.training.conference.form;

/**
 * Pojo representing a profile form on the client side.
 */
public class ProfileForm {
    /**
     * Any string user wants us to display him/her on this system.
     */
    private String displayName;

    /**
     * Gender.
     */
    private Gender gender;

    private ProfileForm () {}

    /**
     * Constructor for ProfileForm, solely for unit test.
     * @param displayName A String for displaying the user on this system.
     * @param notificationEmail An e-mail address for getting notifications from this system.
     */
    public ProfileForm(String displayName, Gender gender) {
        this.displayName = displayName;
        this.gender = gender;
    }

    public String getDisplayName() {
        return displayName;
    }
    
    public Gender getGender() {
        return gender;
    }
    
    public static enum Gender {
    	NOT_SPECIFIED,
        Male,
        Female
    }
}
