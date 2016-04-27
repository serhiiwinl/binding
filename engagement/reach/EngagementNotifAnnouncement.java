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

import java.util.Map;

import com.microsoft.azure.engagement.reach.*;
import org.json.JSONException;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;

/**
 * Engagement Notification Announcement abstraction.
 */
public class EngagementNotifAnnouncement extends EngagementAbstractAnnouncement
{
  /**
   * Parse a notification announcement.
   * @param campaignId already parsed campaign id.
   * @param values campaign data.
   * @param params special parameters to inject in the action URL of the announcement.
   * @throws JSONException if a parsing error occurs.
   */
  EngagementNotifAnnouncement(com.microsoft.azure.engagement.reach.CampaignId campaignId, ContentValues values,
                              Map<String, String> params) throws JSONException
  {
    super(campaignId, values, params);
  }

  @Override
  Intent buildIntent()
  {
    return null;
  }

  @Override
  public void actionNotification(Context context, boolean launchIntent)
  {
    /* Normal behavior */
    super.actionNotification(context, launchIntent);

    /* This is the final step in this content kind */
    process(context, null, null);
  }

  @Override
  public void actionContent(Context context)
  {
    /* Forbid this action on notification only announcements */
    forbidAction();
  }

  @Override
  public void exitContent(Context context)
  {
    /* Forbid this action on notification only announcements */
    forbidAction();
  }

  /**
   * Throws an exception to indicate the caller that the call is forbidden.
   * @throws UnsupportedOperationException always throws it.
   */
  private void forbidAction() throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException("This is a notification only announcement.");
  }
}
