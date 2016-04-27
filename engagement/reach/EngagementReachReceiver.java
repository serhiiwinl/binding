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

package com.partypoker.poker.engagement.reach;

import static com.microsoft.azure.engagement.EngagementIntents.INTENT_EXTRA_TYPE;
import static com.microsoft.azure.engagement.EngagementIntents.INTENT_EXTRA_TYPE_DLC;
import static com.microsoft.azure.engagement.EngagementIntents.INTENT_EXTRA_TYPE_PUSH;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.microsoft.azure.engagement.EngagementAgent;
import com.microsoft.azure.engagement.EngagementIntents;
import com.microsoft.azure.engagement.reach.*;

/**
 * Integrating this class in the AndroidManifest.xml is required for the Reach SDK to be able to
 * process incoming contents and handle system notifications.<br/>
 * Add the following section in the AndroidManifest.xml:
 * 
 * <pre>
 * {@code
 * <receiver android:name="com.microsoft.azure.engagement.reach.EngagementReachReceiver" android:exported="false">
 *   <intent-filter>
 *     <action android:name="android.intent.action.BOOT_COMPLETED"/>
 *     <action android:name="com.microsoft.azure.engagement.intent.action.AGENT_CREATED"/>
 *     <action android:name="com.microsoft.azure.engagement.intent.action.MESSAGE"/>
 *     <action android:name="com.microsoft.azure.engagement.reach.intent.action.ACTION_NOTIFICATION"/>
 *     <action android:name="com.microsoft.azure.engagement.reach.intent.action.EXIT_NOTIFICATION"/>
 *     <action android:name="com.microsoft.azure.engagement.reach.intent.action.DOWNLOAD_TIMEOUT"/>
 *   </intent-filter>
 * </receiver>
 * }
 * </pre>
 */
public class EngagementReachReceiver extends BroadcastReceiver
{
  @Override
  public void onReceive(Context context, Intent intent)
  {
    /* Boot: restore system notifications */
    String action = intent.getAction();
    if (Intent.ACTION_BOOT_COMPLETED.equals(action))
      com.microsoft.azure.engagement.reach.EngagementReachAgent.getInstance(context).onDeviceBoot();

    /* Just ensure the reach agent is loaded for checking pending contents in SQLite */
    else if (EngagementAgent.INTENT_ACTION_AGENT_CREATED.equals(action))
      com.microsoft.azure.engagement.reach.EngagementReachAgent.getInstance(context);

    /* Notification actioned e.g. clicked (from the system notification) */
    else if (com.microsoft.azure.engagement.reach.EngagementReachAgent.INTENT_ACTION_ACTION_NOTIFICATION.equals(action))
      onNotificationActioned(context, intent);

    /* System notification exited (clear button) */
    else if (com.microsoft.azure.engagement.reach.EngagementReachAgent.INTENT_ACTION_EXIT_NOTIFICATION.equals(action))
      onNotificationExited(context, intent);

    /* Called when download takes too much time to complete */
    else if (com.microsoft.azure.engagement.reach.EngagementReachAgent.INTENT_ACTION_DOWNLOAD_TIMEOUT.equals(action))
      onDownloadTimeout(context, intent);

    /* Called when we receive GCM or ADM push with azme parameters or message download completes. */
    else if (EngagementIntents.INTENT_ACTION_MESSAGE.equals(action))
      onMessage(context, intent);
  }

  /**
   * Called when a push message is received or message download completes.
   * @param context context.
   * @param intent intent.
   */
  private void onMessage(Context context, Intent intent)
  {
    String type = intent.getStringExtra(INTENT_EXTRA_TYPE);
    if (INTENT_EXTRA_TYPE_PUSH.equals(type))
      com.microsoft.azure.engagement.reach.EngagementReachAgent.getInstance(context).onContentReceived(intent.getExtras());
    else if (INTENT_EXTRA_TYPE_DLC.equals(type))
      com.microsoft.azure.engagement.reach.EngagementReachAgent.getInstance(context).onMessageDownloaded(intent.getExtras());
  }

  /**
   * Called when a system notification for a content has been actioned.
   * @param context context.
   * @param intent intent describing the content.
   */
  private void onNotificationActioned(Context context, Intent intent)
  {
    /* Get content */
    com.microsoft.azure.engagement.reach.EngagementReachAgent reachAgent = com.microsoft.azure.engagement.reach.EngagementReachAgent.getInstance(context);
    EngagementReachInteractiveContent content = reachAgent.getContent(intent);

    /* If content retrieved successfully */
    if (content != null)

      /* Tell reach to start the content activity */
      content.actionNotification(context, true);
  }

  /**
   * Called when a notification has been exited (clear button from notification panel).
   * @param context context.
   * @param intent intent containing the content identifier to exit.
   */
  private void onNotificationExited(Context context, Intent intent)
  {
    /* Get content */
    com.microsoft.azure.engagement.reach.EngagementReachAgent reachAgent = com.microsoft.azure.engagement.reach.EngagementReachAgent.getInstance(context);
    EngagementReachInteractiveContent content = reachAgent.getContent(intent);

    /* Exit it if found */
    if (content != null)
      content.exitNotification(context);
  }

  /**
   * Called when download times out.
   * @param context application context.
   * @param intent timeout intent containing content identifier.
   */
  private void onDownloadTimeout(Context context, Intent intent)
  {
    /* Delegate to agent */
    com.microsoft.azure.engagement.reach.EngagementReachAgent reachAgent = com.microsoft.azure.engagement.reach.EngagementReachAgent.getInstance(context);
    EngagementReachInteractiveContent content = reachAgent.getContent(intent);
    if (content != null)
      reachAgent.onDownloadTimeout(content);
  }
}
