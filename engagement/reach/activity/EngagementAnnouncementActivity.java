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

package com.partypoker.poker.engagement.reach.activity;

import android.content.Intent;

import com.microsoft.azure.engagement.reach.EngagementAnnouncement;
import com.microsoft.azure.engagement.reach.activity.*;

/**
 * Base class for all announcement activities.
 */
public abstract class EngagementAnnouncementActivity extends
        com.microsoft.azure.engagement.reach.activity.EngagementContentActivity<EngagementAnnouncement>
{
  /**
   * Track if we already executed an action, we want to do it only once (in web announcements we can
   * have an action URL and links in web view which count also as actions).
   */
  private boolean mActioned;

  @Override
  protected void onAction()
  {
    /* Report action */
    mContent.actionContent(getApplicationContext());

    /* Action the URL if specified */
    String url = mContent.getActionURL();
    if (url != null)
      executeActionURL(url);
  }

  /**
   * Execute action URL. Only the first call will be processed (whatever the URL). Other calls are
   * ignored.
   * @param url action URL (not null).
   */
  protected void executeActionURL(String url)
  {
    if (!mActioned)
      try
      {
        startActivity(Intent.parseUri(url, 0));
        mActioned = true;
      }
      catch (Exception e)
      {
        /* Ignore */
      }
  }
}
