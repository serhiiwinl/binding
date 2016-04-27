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

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.microsoft.azure.engagement.reach.*;

/**
 * Integrating this class in the AndroidManifest.xml is required for the Reach SDK to be able to
 * process big picture notifications.<br/>
 * Add the following section in the AndroidManifest.xml:
 * 
 * <pre>
 * {@code <receiver android:name="com.microsoft.azure.engagement.reach.EngagementReachDownloadReceiver">
 *   <intent-filter>
 *     <action android:name="android.intent.action.DOWNLOAD_COMPLETE"/>
 *   </intent-filter>
 * </receiver>
 * }
 * </pre>
 */
public class EngagementReachDownloadReceiver extends BroadcastReceiver
{
  @Override
  public void onReceive(Context context, Intent intent)
  {
    /* Big picture downloaded */
    if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(intent.getAction()))
    {
      /* Get content by download id */
      long downloadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, 0);
      com.microsoft.azure.engagement.reach.EngagementReachAgent reachAgent = com.microsoft.azure.engagement.reach.EngagementReachAgent.getInstance(context);
      EngagementReachInteractiveContent content = reachAgent.getContentByDownloadId(downloadId);

      /* Delegate to agent if content found */
      if (content != null)
        reachAgent.onDownloadComplete(content);
    }
  }
}
