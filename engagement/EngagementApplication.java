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

package com.partypoker.poker.engagement;

import android.app.Application;
import android.content.res.Configuration;
import com.microsoft.azure.engagement.*;

/**
 * Helper class used to replace Android's {@link Application} class.<br/>
 * If you currently extend the {@link Application} class, please make your class extend this class
 * instead. Your {@link #onCreate()} function has to be renamed
 * {@link #onApplicationProcessCreate()} and the same rule applies for the other callbacks. Make
 * sure to also rename the calls to the super methods the same way to avoid an infinite loop (which
 * will trigger a <tt>java.lang.StackOverflowError</tt>).<br/>
 * These new methods are called only if the current process is not dedicated to the Engagement service,
 * avoiding unnecessary initialization in that process.<br/>
 * If you use an Application sub-class but you don't want to extend this class, you can use directly
 * {@link com.microsoft.azure.engagement.EngagementAgentUtils#isInDedicatedEngagementProcess(android.content.Context)} and execute your legacy
 * code only if this method return <tt>false</tt>.
 * @see com.microsoft.azure.engagement.EngagementAgentUtils#isInDedicatedEngagementProcess(android.content.Context)
 */
public abstract class EngagementApplication extends Application
{
  @Override
  public final void onCreate()
  {
    if (!com.microsoft.azure.engagement.EngagementAgentUtils.isInDedicatedEngagementProcess(this))
      onApplicationProcessCreate();
  }

  @Override
  public final void onTerminate()
  {
    if (!com.microsoft.azure.engagement.EngagementAgentUtils.isInDedicatedEngagementProcess(this))
      onApplicationProcessTerminate();
  }

  @Override
  public final void onLowMemory()
  {
    if (!com.microsoft.azure.engagement.EngagementAgentUtils.isInDedicatedEngagementProcess(this))
      onApplicationProcessLowMemory();
  }

  @Override
  public final void onConfigurationChanged(Configuration newConfig)
  {
    if (!com.microsoft.azure.engagement.EngagementAgentUtils.isInDedicatedEngagementProcess(this))
      onApplicationProcessConfigurationChanged(newConfig);
  }

  /**
   * Override this method instead of {@link #onCreate()} to avoid doing unnecessary operations when
   * the current process is the one dedicated to the Engagement service.
   */
  protected void onApplicationProcessCreate()
  {
    /* Sub-class template method */
  }

  /**
   * Override this method instead of {@link #onTerminate()} to avoid doing unnecessary operations
   * when the current process is the one dedicated to the Engagement service.
   */
  protected void onApplicationProcessTerminate()
  {
    /* Sub-class template method */
  }

  /**
   * Override this method instead of {@link #onLowMemory()} to avoid doing unnecessary operations
   * when the current process is the one dedicated to the Engagement service.
   */
  protected void onApplicationProcessLowMemory()
  {
    /* Sub-class template method */
  }

  /**
   * Override this method instead of {@link #onConfigurationChanged(Configuration)} to avoid doing
   * unnecessary operations when the current process is the one dedicated to the Engagement service.
   */
  protected void onApplicationProcessConfigurationChanged(Configuration newConfig)
  {
    /* Sub-class template method */
  }
}
