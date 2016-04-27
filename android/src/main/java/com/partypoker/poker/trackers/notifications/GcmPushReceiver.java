package com.partypoker.poker.trackers.notifications;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.otherlevels.android.sdk.PushReceiver;
import com.otherlevels.android.sdk.ServiceReceiver;
import com.partypoker.poker.BaseApplication;

/**
 * Created by sliubetskyi on 4/18/16.
 */
public class GcmPushReceiver extends PushReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        BaseApplication app = (BaseApplication) context.getApplicationContext();
        if (app.getCurrentActivity() == null) {
            super.onReceive(context, intent);
            intent.getFlags();
        } else {
            try {
               app.getCurrentActivity().showInAppPushNotification(intent);
            } finally {
                //ServiceReceiver.completeWakefulIntent(intent);
            }
        }
    }
}
