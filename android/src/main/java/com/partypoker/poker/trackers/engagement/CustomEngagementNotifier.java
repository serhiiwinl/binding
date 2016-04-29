package com.partypoker.poker.trackers.engagement;

import android.content.Context;
import com.microsoft.azure.engagement.reach.EngagementDefaultNotifier;
import com.microsoft.azure.engagement.reach.EngagementReachInteractiveContent;

/**
 * Created by sliubetskyi on 4/25/16.
 */
public class CustomEngagementNotifier extends EngagementDefaultNotifier {
    public EngagementReachInteractiveContent content;
    //TODO: it is mock data, it will be moved into other place
    public boolean pushAllowed = false;
    private static CustomEngagementNotifier instance = null;

    private CustomEngagementNotifier(Context context) {
        super(context);
    }

    public static CustomEngagementNotifier getInstance(Context context) {
        if(instance == null) {
            synchronized (CustomEngagementNotifier.class) {
                if(instance == null) {
                    instance = new CustomEngagementNotifier(context);
                }
            }
        }
        return instance;
    }

    @Override
    public Boolean handleNotification(EngagementReachInteractiveContent content) throws RuntimeException {
        if (this.pushAllowed) {
            this.content = null;
            return super.handleNotification(content);
        } else {
            if (this.content == null)
                this.content = content;
            return false;
        }
    }

    public boolean handlePendingNotification() {
        return handleNotification(this.content);
    }
}
