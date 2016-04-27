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

package com.partypoker.poker.engagement.utils;

import static android.content.pm.PackageManager.GET_META_DATA;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

/** Utility functions */
public final class EngagementUtils
{
  private EngagementUtils()
  {
    /* Prevent instantiation */
  }

  /**
   * Get application meta-data of the current package name.
   * @param context application context.
   * @return meta-data, may be empty but never null.
   */
  public static Bundle getMetaData(Context context)
  {
    Bundle config;
    try
    {
      config = context.getPackageManager().getApplicationInfo(context.getPackageName(),
        PackageManager.GET_META_DATA).metaData;
      if (config == null)
        config = new Bundle();
    }
    catch (Exception e)
    {
      /*
       * NameNotFoundException or in some rare scenario an undocumented "RuntimeException: Package
       * manager has died.", probably caused by a system app process crash.
       */
      config = new Bundle();
    }
    return config;
  }

  /**
   * Get activity meta-data.
   * @param activity activity to get meta-data from.
   * @return meta-data, may be empty but never null.
   */
  public static Bundle getActivityMetaData(Activity activity)
  {
    Bundle config;
    try
    {
      config = activity.getPackageManager().getActivityInfo(activity.getComponentName(),
        GET_META_DATA).metaData;
      if (config == null)
        config = new Bundle();
    }
    catch (Exception e)
    {
      /*
       * NameNotFoundException or in some rare scenario an undocumented "RuntimeException: Package
       * manager has died.", probably caused by a system app process crash.
       */
      config = new Bundle();
    }
    return config;
  }
}
