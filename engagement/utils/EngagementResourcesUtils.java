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

import android.content.Context;
import android.view.View;

/** Utility functions for retrieving resource identifiers by their name. */
public final class EngagementResourcesUtils
{
  private EngagementResourcesUtils()
  {
    /* Prevent instantiation */
  }

  /**
   * Get resource identifier.
   * @param context any application context.
   * @param name resource name.
   * @param defType resource type like "layout" or "id".
   * @return resource identifier or 0 if not found.
   */
  public static int getId(Context context, String name, String defType)
  {
    try
    {
      return context.getResources().getIdentifier(name, defType, context.getPackageName());
    }
    catch (RuntimeException e)
    {
      /*
       * We had some NullPointerException reported by an application, but the stack trace was
       * actually showing a call stack that is not matching our SDK code in
       * EngagementDefaultNotifier.notify triggered from the GCM receiver. If context or
       * getResources was null, it would crash earlier in the constructor, plus notify itself is
       * tried/caught by reach agent so having an uncaught exception in this code path cannot
       * happen. It's either a weird Proguard optimization or a patched SDK triggering this. Fall
       * back into an invalid identifier to avoid a force close.
       */
      return 0;
    }
  }

  /**
   * Get layout identifier by its resource name.
   * @param context any application context.
   * @param name layout resource name.
   * @return layout identifier or 0 if not found.
   */
  public static int getLayoutId(Context context, String name)
  {
    return getId(context, name, "layout");
  }

  /**
   * Get drawable identifier by its resource name.
   * @param context any application context.
   * @param name drawable resource name.
   * @return drawable identifier or 0 if not found.
   */
  public static int getDrawableId(Context context, String name)
  {
    return getId(context, name, "drawable");
  }

  /**
   * Get identifier by its resource name.
   * @param context any application context.
   * @param name identifier resource name.
   * @return identifier or 0 if not found.
   */
  public static int getId(Context context, String name)
  {
    return getId(context, name, "id");
  }

  /**
   * Get a view by its resource name.
   * @param view ancestor view.
   * @param name view identifier resource name.
   * @return view or 0 if not found.
   */
  @SuppressWarnings("unchecked")
  public static <T extends View> T getView(View view, String name)
  {
    return (T) view.findViewById(getId(view.getContext(), name));
  }
}
