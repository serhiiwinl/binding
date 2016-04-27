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
 * Engagement DataPush abstraction.
 */
public class EngagementDataPush extends EngagementReachContent
{
  /** Intent action used by the Reach SDK. */
  public static final String INTENT_ACTION = "com.microsoft.azure.engagement.reach.intent.action.DATA_PUSH";

  /** Special parameters to inject in the body of the datapush. */
  private final Map<String, String> params;

  /** MIME type */
  private String mType;

  /**
   * Parse a datapush.
   * @param campaignId already parsed campaign id.
   * @param values campaign data.
   * @param params special parameters to inject in the body of the datapush.
   * @throws JSONException if payload parsing error occurs.
   */
  EngagementDataPush(com.microsoft.azure.engagement.reach.CampaignId campaignId, ContentValues values, Map<String, String> params)
    throws JSONException
  {
    super(campaignId, values);
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
    /*
     * Unlike interactive contents whose content is either cached in RAM (current content) or
     * retrieved from SQLite from its identifier (to handle application restart for system
     * notifications), we drop the content as soon as the first broadcast receiver that handles
     * datapush acknowledges or cancel the content. We need to put data in the intent to handle
     * several broadcast receivers.
     */
    Intent intent = new Intent(INTENT_ACTION);
    intent.putExtra("category", mCategory);
    intent.putExtra("body", mBody);
    intent.putExtra("type", mType);
    return intent;
  }

  /**
   * Get encoding type for the body.
   * @return "text/plain or "text/base64".
   */
  public String getType()
  {
    return mType;
  }
}
