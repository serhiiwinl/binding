/*
 * Azure Mobile Engagement Android SDK
 * Copyright (c) Microsoft Corporation
 *
 * All rights reserved.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the ""Software""), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.partypoker.poker.engagement.gcm;

import static com.microsoft.azure.engagement.EngagementNativePushToken.Type.GCM;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.microsoft.azure.engagement.EngagementNativePushToken;
import com.microsoft.azure.engagement.gcm.*;
import com.microsoft.azure.engagement.nativepush.EngagementNativePushAgent;

/**
 * This class is required to communicate the GCM registration id to the Engagement Push service and
 * to receive GCM messages. Add this to your AndroidManifest.xml:
 * 
 * <pre>
 * {@code
 * <receiver android:name="com.microsoft.azure.engagement.gcm.EngagementGCMReceiver" android:permission="com.google.android.c2dm.permission.SEND">
 *   <intent-filter>
 *     <action android:name="com.google.android.c2dm.intent.REGISTRATION" />
 *     <action android:name="com.google.android.c2dm.intent.RECEIVE" />
 *     <category android:name="<your_package_name>" />
 *   </intent-filter>
 * </receiver>
 * }
 * </pre>
 * 
 * Please ensure you have the following permissions:
 * 
 * <pre>
 * {@code
 * <uses-permission android:name="com.google.android.c2dm.permission.RECEIVE" />
 * <uses-permission android:name="<your_package_name>.permission.C2D_MESSAGE" />
 * <permission android:name="<your_package_name>.permission.C2D_MESSAGE" android:protectionLevel="signature" />
 * }
 * </pre>
 * 
 * You also have to integrate {@link com.microsoft.azure.engagement.gcm.EngagementGCMEnabler} if you don't already manage the
 * registration intent yourself.
 * @see com.microsoft.azure.engagement.gcm.EngagementGCMEnabler
 */
public class EngagementGCMReceiver extends BroadcastReceiver
{
  /** Action when we receive token */
  private static final String INTENT_ACTION_REGISTRATION = "com.google.android.c2dm.intent.REGISTRATION";

  /** Token key in intent result */
  private static final String INTENT_EXTRA_REGISTRATION = "registration_id";

  /** Action when we receive a push */
  public static final String INTENT_ACTION_RECEIVE = "com.google.android.c2dm.intent.RECEIVE";

  @Override
  public void onReceive(Context context, Intent intent)
  {
    /* Registration result action */
    String action = intent.getAction();
    if (INTENT_ACTION_REGISTRATION.equals(action))
    {
      /* Handle register if successful (otherwise we'll retry next time process is started) */
      String registrationId = intent.getStringExtra(INTENT_EXTRA_REGISTRATION);
      if (registrationId != null)
      {
        /* Send registration id to the Engagement Push service */
        EngagementNativePushAgent nativePushAgent = EngagementNativePushAgent.getInstance(context);
        nativePushAgent.registerNativePush(new EngagementNativePushToken(registrationId, GCM));
      }
    }

    /* Received message action */
    else if (INTENT_ACTION_RECEIVE.equals(action))
      EngagementNativePushAgent.getInstance(context).onPushReceived(intent.getExtras());
  }
}
