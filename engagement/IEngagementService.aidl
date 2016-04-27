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

package com.microsoft.azure.engagement;

import android.os.Bundle;
import com.microsoft.azure.engagement.EngagementConfiguration;
import com.microsoft.azure.engagement.EngagementNativePushToken;

/**
 * Engagement API, the Engagement service returns this remote interface when binding to it.<br/>
 * The binding intent has just the Engagement service as component name, nothing else.
 * This class is not designed to be used directly in user code, please use {@link com.microsoft.azure.engagement.EngagementAgent} instead.
 * @see com.microsoft.azure.engagement.EngagementAgent
 */
interface IEngagementService
{
  oneway void init(in EngagementConfiguration configuration);

  oneway void startActivity(String activityName, in Bundle extras);

  oneway void endActivity();

  oneway void startJob(String name, in Bundle extras);

  oneway void endJob(String name);

  oneway void sendEvent(String name, in Bundle extras);

  oneway void sendSessionEvent(String name, in Bundle extras);

  oneway void sendJobEvent(String name, String jobName, in Bundle extras);

  oneway void sendError(String name, in Bundle extras);

  oneway void sendSessionError(String name, in Bundle extras);

  oneway void sendJobError(String name, String jobName, in Bundle extras);

  String getDeviceId();

  oneway void sendAppInfo(in Bundle appInfo);

  oneway void sendReachFeedback(String kind, String contentId, String status, in Bundle extras);

  oneway void registerNativePush(in EngagementNativePushToken token);

  oneway void getMessage(String id);
}
