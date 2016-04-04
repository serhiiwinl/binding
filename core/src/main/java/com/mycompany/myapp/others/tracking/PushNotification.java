package com.mycompany.myapp.others.tracking;

/**
 * Created by sliubetskyi on 3/23/16.
 */
public class PushNotification {
    private String title = "";
    private String message = "";

    public PushNotification (String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }
}
