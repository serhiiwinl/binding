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

import com.microsoft.azure.engagement.storage.EngagementStorage;

/** Constants used in SQLite */
final class ContentStorage
{
  /** Content local identifier */
  static final String OID = EngagementStorage.PRIMARY_KEY;

  /** Content reach campaign identifier */
  static final String CAMPAIGN_ID = "ci";

  /** DLC flag */
  static final String DLC = "dlc";

  /** Content DLC id */
  static final String DLC_ID = "id";

  /** Category */
  static final String CATEGORY = "cat";

  /** Delivery time */
  static final String DELIVERY_TIME = "dt";

  /** Campaign end time */
  static final String TTL = "ttl";

  /** Campaign end time user time zone flag */
  static final String USER_TIME_ZONE = "utz";

  /** Notification type */
  static final String NOTIFICATION_TYPE = "nt";

  /** Notification icon */
  static final String NOTIFICATION_ICON = "ic";

  /** Notification closeable */
  static final String NOTIFICATION_CLOSEABLE = "cl";

  /** Notification vibration */
  static final String NOTIFICATION_VIBRATION = "v";

  /** Notification sound */
  static final String NOTIFICATION_SOUND = "s";

  /** Notification title */
  static final String NOTIFICATION_TITLE = "tle";

  /** Notification message */
  static final String NOTIFICATION_MESSAGE = "msg";

  /** Notification big text */
  static final String NOTIFICATION_BIG_TEXT = "bt";

  /** Notification big picture */
  static final String NOTIFICATION_BIG_PICTURE = "bp";

  /** Action URL */
  static final String ACTION_URL = "au";

  /** Campaign JSON payload (dlc) */
  static final String PAYLOAD = "payload";

  /** Download identifier for attached file */
  static final String DOWNLOAD_ID = "download_id";

  /** Notification first displayed date */
  static final String NOTIFICATION_FIRST_DISPLAYED_DATE = "notification_first_displayed_date";

  /** Notification last displayed date */
  static final String NOTIFICATION_LAST_DISPLAYED_DATE = "notification_last_displayed_date";

  /** Notification actioned flag */
  static final String NOTIFICATION_ACTIONED = "notification_actioned";

  /** Content displayed flag */
  static final String CONTENT_DISPLAYED = "content_displayed";
}
