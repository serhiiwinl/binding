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
import org.json.JSONObject;

import android.content.ContentValues;
import android.content.Intent;

/**
 * Engagement Announcement abstraction.
 */
public class EngagementAnnouncement extends EngagementAbstractAnnouncement
{
  /** Intent action used by the Reach SDK. */
  public static final String INTENT_ACTION = "com.microsoft.azure.engagement.reach.intent.action.ANNOUNCEMENT";

  /** Special parameters to inject in the body of the datapush. */
  private final Map<String, String> params;

  /** MIME type */
  private String mType;

  /**
   * Parse an announcement.
   * @param campaignId already parsed campaign id.
   * @param values campaign data.
   * @param params special parameters to inject in the action URL and body of the announcement.
   * @throws JSONException if a parsing error occurs.
   */
  EngagementAnnouncement(com.microsoft.azure.engagement.reach.CampaignId campaignId, ContentValues values, Map<String, String> params)
    throws JSONException
  {
    super(campaignId, values, params);
    this.params = params;
    replacePayloadParams();
  }

  @Override
  void setPayload(JSONObject payload) throws JSONException
  {
    super.setPayload(payload);
    replacePayloadParams();
    mType = payload.getString("type");
  }

  /** Replace parameters within payload fields that support them */
  private void replacePayloadParams()
  {
    if (params != null)
      for (Map.Entry<String, String> param : params.entrySet())
      {
        if (mBody != null)
          mBody = mBody.replace(param.getKey(), param.getValue());
      }
  }

  @Override
  Intent buildIntent()
  {
    Intent intent = new Intent(INTENT_ACTION);
    intent.setType(getType());
    String category = getCategory();
    if (category != null)
      intent.addCategory(category);
    return intent;
  }

  /**
   * Get the mime type for this announcement. This is useful to interpret the text returned by
   * {@link #getBody()}. This type will also be set in the intent that launches the viewing
   * activity.
   * @return mime type.
   */
  public String getType()
  {
    return mType;
  }
}
