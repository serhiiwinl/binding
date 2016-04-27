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

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.microsoft.azure.engagement.gcm.EngagementGCMReceiver;
import com.microsoft.azure.engagement.nativepush.EngagementNativePushAgent;
import com.microsoft.azure.engagement.utils.EngagementUtils;

/**
 * This broadcast receiver is required for GCM to work. Add this section in your AndroidManifest.xml
 * file:
 * 
 * <pre>
 * {@code <receiver android:name="com.microsoft.azure.engagement.gcm.EngagementGCMEnabler" android:exported="false">
 *   <intent-filter>
 *     <action android:name="com.microsoft.azure.engagement.intent.action.APPID_GOT" />
 *   </intent-filter>
 * </receiver>}
 * </pre>
 * 
 * Additionally and unless you send the <tt>com.google.android.c2dm.intent.REGISTER</tt> yourself,
 * you must configure the GCM sender like this:
 * 
 * <pre>
 * {@code <meta-data android:name="engagement:gcm:sender" android:value="<projectID\n>" />}
 * </pre>
 * 
 * Warning: the <tt>\n</tt> in the sender value is required, otherwise a parsing problem occurs. <br/>
 * <br/>
 * Note that this receiver is mandatory whether you configure it to use the sender for you or not.
 * You must also integrate {@link EngagementGCMReceiver}.
 * @see EngagementGCMReceiver
 */
public class EngagementGCMEnabler extends BroadcastReceiver
{
  @Override
  public void onReceive(Context context, Intent intent)
  {
    /* Once the application identifier is known */
    if ("com.microsoft.azure.engagement.intent.action.APPID_GOT".equals(intent.getAction()))
    {
      /* Init the native push agent */
      String appId = intent.getStringExtra("appId");
      EngagementNativePushAgent.getInstance(context).onAppIdGot(appId);

      /*
       * Request GCM registration identifier, this is asynchronous, the response is made via a
       * broadcast intent with the <tt>com.google.android.c2dm.intent.REGISTRATION</tt> action.
       */
      String sender = EngagementUtils.getMetaData(context).getString("engagement:gcm:sender");
      if (sender != null)
      {
        /* Launch registration process */
        Intent registrationIntent = new Intent("com.google.android.c2dm.intent.REGISTER");
        registrationIntent.setPackage("com.google.android.gsf");
        registrationIntent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        registrationIntent.putExtra("sender", sender.trim());
        try
        {
          context.startService(registrationIntent);
        }
        catch (RuntimeException e)
        {
          /* Abort if the GCM service can't be accessed. */
        }
      }
    }
  }
}
