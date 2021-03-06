package com.partypoker.poker.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.otherlevels.android.sdk.OlAndroidLibrary;
import com.otherlevels.android.sdk.internal.log.Logger;
import com.partypoker.poker.BaseApplication;
import com.partypoker.poker.R;
import com.partypoker.poker.others.BrandComponentFactory;
import com.partypoker.poker.others.CommonInit;
import com.partypoker.poker.others.State;
import com.partypoker.poker.trackers.engagement.CustomEngagementNotifier;
import org.json.JSONObject;

import java.util.Iterator;

public class MainActivity extends Activity implements State<MainActivity> {

    static final Integer pCodeLength = 5;
    private static final String tag = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onNewIntent(getIntent());
        setContentView(R.layout.activity_my);

        initAll();

        final TextView counterTextView = (TextView) findViewById(R.id.counterTextView);
        final Button counterButton = (Button) findViewById(R.id.counterButton);


        counterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BrandComponentFactory.getInstance().getAppUsageTracker().trackLoginSuccess("testUser", "sdsdse11223dssd");
                counterTextView.setText("Click Nr. " + 1);
                CustomEngagementNotifier.getInstance(MainActivity.this).pushAllowed = true;
                CustomEngagementNotifier.getInstance(MainActivity.this).handlePendingNotification();
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        getMyApplication().setCurrentActivity(this);
        BrandComponentFactory.getInstance().getAppUsageTracker().onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getMyApplication().setCurrentActivity(null);
    }

    protected BaseApplication getMyApplication() {
        return (BaseApplication) getApplication();
    }

    private void initAll() {
        new CommonInit();
    }

    public void showInAppPushNotification(Intent intent) {
        Log.d(tag, "showInAppPushNotification: " + intent);

        if (intent.getAction() != null) {
            if (intent.getAction().equalsIgnoreCase("com.google.android.c2dm.intent.RECEIVE")) {
                if (intent.getExtras() != null) {
                    Bundle bundle = intent.getExtras();
                    //buildMessage(bundle);
                    displayNotification(intent);
                }
            }
        }
        //show toast

        CharSequence text = "In app push notification!";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
    }

    @Override
    public void onNewIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            OlAndroidLibrary.getInstance(getApplicationContext()).registerIntent(intent);
        }
        displayNotification(intent);
    }

    public void buildMessage(Bundle extras) {
        String pHash = null;
        JSONObject metaData = new JSONObject();
        String messageText = null;

        try {
            Iterator e = extras.keySet().iterator();

            label32:
            while (true) {
                while (true) {
                    if (!e.hasNext()) {
                        break label32;
                    }

                    String key = (String) e.next();
                    if (key.compareToIgnoreCase("p") == 0 && extras.getString("p").length() > pCodeLength.intValue()) {
                        pHash = extras.getString(key);
                    } else if (key.compareToIgnoreCase("payload") == 0 && extras.getString(key).length() > 0) {
                        messageText = extras.getString(key);
                    } else {
                        metaData.put(key, extras.get(key));
                    }
                }
            }
        } catch (Exception var7) {
            Logger.e("Error with push payload", var7);
        }

        //this.buildMessage(messageText, metaData, pHash);
    }

    // Display the remote notification
    private void displayNotification(Intent intent) {
        Context mContext = getApplicationContext();
        CharSequence tickerText = "null";
        Bundle extras = intent.getExtras();
        final PackageManager pm = mContext.getPackageManager();
        ApplicationInfo ai;
        try {
            ai = pm.getApplicationInfo(mContext.getPackageName(), 0);
        } catch (final PackageManager.NameNotFoundException e) {
            ai = null;
        }
        final String applicationName = (String) (ai != null ? pm.getApplicationLabel(ai) : "(unknown)");
        @SuppressWarnings("unused")
        String pHash = "";
        try {
            for (String key : extras.keySet()) {
                if (key.compareToIgnoreCase("p") == 0 && extras.getString(key).length() > pCodeLength) {
                    pHash = extras.getString(key);
                } else if (key.compareToIgnoreCase("payload") == 0 && extras.getString(key).length() > 0) {
                    tickerText = extras.getString(key);
                }
                Log.d(tag, String.format("onMessage: %s=%s", key, extras.getString(key)));
            }
        } catch (NullPointerException npe) {
            tickerText = "no key=msg has been provided.";
        }
    }

    @Override
    public MainActivity getActivity() {
        return this;
    }

    @Override
    public String getActivityName() {
        return tag;
    }
}
