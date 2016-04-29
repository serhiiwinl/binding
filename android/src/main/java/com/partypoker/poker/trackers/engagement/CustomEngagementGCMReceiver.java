package com.partypoker.poker.trackers.engagement;

import android.content.Context;
import android.content.Intent;
import com.microsoft.azure.engagement.EngagementIntents;
import com.microsoft.azure.engagement.gcm.EngagementGCMReceiver;
import com.microsoft.azure.engagement.nativepush.EngagementNativePushAgent;

/**
 * Created by sliubetskyi on 4/26/16.
 */
public class CustomEngagementGCMReceiver extends EngagementGCMReceiver {

    private static final String INTENT_EXTRA_AZME = "azme";


    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (INTENT_ACTION_RECEIVE.equals(action)) {
            if (intent.getExtras().containsKey(INTENT_EXTRA_AZME)) {
                EngagementNativePushAgent.getInstance(context).onPushReceived(intent.getExtras());
            }
        } else {
            super.onReceive(context, intent);
        }
    }
}
