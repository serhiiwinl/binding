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

import static com.microsoft.azure.engagement.reach.ContentStorage.ACTION_URL;

import java.util.Map;

import com.microsoft.azure.engagement.reach.*;
import org.json.JSONException;

import android.content.ContentValues;

/** Base class for all kind of announcements. */
public abstract class EngagementAbstractAnnouncement extends EngagementReachInteractiveContent
{
  /** Action's URL */
  private final String mActionURL;

  /**
   * Parse an announcement.
   * @param campaignId already parsed campaign id.
   * @param values campaign data.
   * @param params special parameters to inject in the action URL of the announcement.
   * @throws JSONException if a parsing error occurs.
   */
  EngagementAbstractAnnouncement(com.microsoft.azure.engagement.reach.CampaignId campaignId, ContentValues values,
                                 Map<String, String> params) throws JSONException
  {
    super(campaignId, values);
    String actionURL = values.getAsString(ACTION_URL);
    for (Map.Entry<String, String> param : params.entrySet())
    {
      if (actionURL != null)
        actionURL = actionURL.replace(param.getKey(), param.getValue());
    }
    mActionURL = actionURL;
  }

  /**
   * Get action's URL.
   * @return action's URL.
   */
  public String getActionURL()
  {
    return mActionURL;
  }
}
