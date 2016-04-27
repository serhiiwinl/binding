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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;

/** Crash identifier */
class EngagementCrashId
{
  /** Packages that are not considered the origin of an exception in the stack traces */
  /* @formatter:off */
  private static final String[] STACK_TRACE_PACKAGE_SKIP_LIST = {
    "android",
    "com.android",
    "dalvik",
    "java.lang.reflect"
  };
  /* @formatter:on */

  /** Crash type */
  private final Class<?> type;

  /** Crash location class */
  private final String locationClass;

  /** Crash location method */
  private final String locationMethod;

  /**
   * Init crash identifier.
   * @param type crash type.
   * @param location crash location (origin of the crash in the stack trace).
   */
  private EngagementCrashId(Class<?> type, StackTraceElement location)
  {
    this(type, location.getClassName(), location.getMethodName());
  }

  /**
   * Init crash identifier.
   * @param type crash type.
   * @param locationClass origin class of the crash.
   * @param locationMethod origin method of the crash.
   */
  private EngagementCrashId(Class<?> type, String locationClass, String locationMethod)
  {
    this.type = type;
    this.locationClass = locationClass;
    this.locationMethod = locationMethod;
  }

  /**
   * Get crash type.
   * @return crash type.
   */
  public String getType()
  {
    return type.getName();
  }

  /**
   * Get crash location as a string.
   * @return crash location as a string.
   */
  public String getLocation()
  {
    /*
     * We don't use line number because it can be variable for the same semantic crash: different
     * Android versions, different application versions with the same crash not being fixed (but
     * with origin source file being modified).
     */
    if (locationClass == null)
      return null;
    else
      return locationClass + "." + locationMethod;
  }

  /**
   * Get crash identifier from the specified throwable.
   * @param ex throwable.
   * @return crash identifier.
   */
  public static EngagementCrashId from(Context context, Throwable ex)
  {
    /*
     * Loop on causes to determine exception type to use and class/method to use for crashid
     * computation. The class.method used as the location of a crash (the origin of the crash) is
     * never considered to be an Android method, try to find an application method as being the
     * origin of the crash. If we don't find one, use the first method as origin. OutOfMemoryError
     * is special: it can happen pretty much everywhere, use no origin for this one: aggregate all
     * OutOfMemoryError into one crash identifier (whatever its position in the causal chain).
     */
    Class<? extends Throwable> topClassName = ex.getClass();
    for (Throwable cause = ex; cause != null; cause = cause.getCause())
      if (cause.getClass().equals(OutOfMemoryError.class))
        return new EngagementCrashId(OutOfMemoryError.class, null, null);
      else
        for (StackTraceElement line : cause.getStackTrace())
          if (!isAndroidLine(line))
            return new EngagementCrashId(topClassName, line);

    /*
     * Very specific case: RuntimeException thrown by ActivityThread. There is no hint of
     * application code in the stack trace lines, only the message can be parsed. Keep original
     * method name but change ActivityThread by the application class name found in the message.
     */
    StackTraceElement firstLine = ex.getStackTrace()[0];
    if (ex instanceof RuntimeException
      && "android.app.ActivityThread".equals(firstLine.getClassName()))
    {
      /* Try parsing message for class name */
      Pattern pattern = Pattern.compile("\\{" + context.getPackageName() + "/([^\\}]+)");
      Matcher matcher = pattern.matcher(ex.getMessage());
      if (matcher.find())
        return new EngagementCrashId(topClassName, matcher.group(1), firstLine.getMethodName());
    }

    /* Fail over first type and line if no smart origin could be found */
    return new EngagementCrashId(topClassName, firstLine);
  }

  /**
   * Check whether a stack trace line is part of the Android source code, or generated by Android
   * source code.
   * @param line stack trace line.
   * @return true if part of Android source code, false otherwise.
   */
  private static boolean isAndroidLine(StackTraceElement line)
  {
    for (String prefix : STACK_TRACE_PACKAGE_SKIP_LIST)
      if (line.getClassName().startsWith(prefix + "."))
        return true;
    return false;
  }
}
