package com.partypoker.poker.trackers.engagement;

import android.content.Context;
import com.microsoft.azure.engagement.reach.EngagementDefaultNotifier;
import com.microsoft.azure.engagement.reach.EngagementReachInteractiveContent;

/**
 * Created by sliubetskyi on 4/25/16.
 */
public class CustomEngagementNotifier extends EngagementDefaultNotifier {
    public CustomEngagementNotifier(Context context) {
        super(context);
    }

    @Override
    public Boolean handleNotification(EngagementReachInteractiveContent content) throws RuntimeException {
        return super.handleNotification(content);
    }
}
