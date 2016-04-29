package com.partypoker.poker.trackers.engagement;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.microsoft.azure.engagement.EngagementAgent;
import com.microsoft.azure.engagement.EngagementConfiguration;
import com.microsoft.azure.engagement.reach.EngagementReachAgent;
import com.partypoker.poker.BaseApplication;
import com.partypoker.poker.Config;
import com.partypoker.poker.others.State;
import com.partypoker.poker.trackers.TrackingList;
import com.partypoker.poker.trackers.concrete.EngagementTracker;
import com.partypoker.poker.tracking.IBaseApplicationActions;
import com.partypoker.poker.tracking.IConfigLoaded;

/**
 * Created by sliubetskyi on 4/22/16.
 */
@TrackingList(value = {IBaseApplicationActions.class, IConfigLoaded.class})
public class EngagementTrackerAndroid extends EngagementTracker {

    private static final String tag = EngagementTrackerAndroid.class.getSimpleName();
    private BaseApplication app;

    @Override
    public void onAttachToApp(Object app) {
        super.onAttachToApp(app);
        this.app = (BaseApplication) app;
    }

    @Override
    public void onConfigLoaded(Config config) {
        EngagementConfiguration engagementConfiguration = new EngagementConfiguration();
        engagementConfiguration.setConnectionString(getConnectionString(Config.engagementEndpoint, Config.engagementAppId,
                Config.engagementSdkKey));
        EngagementAgent.getInstance(this.app).init(engagementConfiguration);
        EngagementReachAgent.getInstance(this.app).registerNotifier(CustomEngagementNotifier.getInstance(this.app), Intent.CATEGORY_DEFAULT);
        EngagementAgent.getInstance(this.app).getDeviceId(new EngagementAgent.Callback<String>() {

            @Override
            public void onResult(String deviceId) {
                Log.d(tag, "Engagement device id: " + deviceId);
            }

        });
        requestGCM(this.app);
        this.isInitialized = true;
    }

    /*
    * Request GCM registration identifier, this is asynchronous, the response is made via a
    * broadcast intent with the <tt>com.google.android.c2dm.intent.REGISTRATION</tt> action.
    */
    private void requestGCM(Context context) {
        //We get sender from our config, not from manifest metaData
        //String sender = EngagementUtils.getMetaData(context).getString("engagement:gcm:sender");
        //TODO:
        String sender = Config.gsmSenderAzure;
        if (sender != null) {
        /* Launch registration process */
            Intent registrationIntent = new Intent("com.google.android.c2dm.intent.REGISTER");
            registrationIntent.setPackage("com.google.android.gsf");
            registrationIntent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
            registrationIntent.putExtra("sender", sender.trim());
            try {
                context.startService(registrationIntent);
            } catch (RuntimeException e) {
                /* Abort if the GCM service can't be accessed. */
            }
        }
    }

    @Override
    public void onPause(State activity) {
        if (isInitialized)
            EngagementAgent.getInstance(this.app).endActivity();
    }

    @Override
    public void onResume(State activity) {
        if (isInitialized)
            EngagementAgent.getInstance(this.app).startActivity((Activity) activity.getActivity(), activity.getActivityName(), null);
    }
}
