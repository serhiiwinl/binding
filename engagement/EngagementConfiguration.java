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

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Engagement configuration. This contains configuration that can be dynamically changed at runtime.
 * All the fields are optional.
 */
public class EngagementConfiguration implements Parcelable
{
  /** Prefix for keys */
  private static final String PREFIX = "engagement:";

  /** Device identifier flag */
  public static final String DEVICE_ID = PREFIX + "deviceId";

  /** Location report key prefix */
  private static final String LOCATION_REPORT_PREFIX = PREFIX + "locationReport:";

  /** Lazy location report flag */
  public static final String LOCATION_REPORT_LAZY_AREA = LOCATION_REPORT_PREFIX + "lazyArea";

  /** Real-time location report flag */
  public static final String LOCATION_REPORT_REAL_TIME = LOCATION_REPORT_PREFIX + "realTime";

  /** Real-time location report flag (fine mode) */
  public static final String LOCATION_REPORT_REAL_TIME_FINE = LOCATION_REPORT_REAL_TIME + ":fine";

  /** Real-time location report flag (background mode) */
  public static final String LOCATION_REPORT_REAL_TIME_BACKGROUND = LOCATION_REPORT_REAL_TIME
    + ":background";

  /** Parcelable factory */
  public static final Creator<EngagementConfiguration> CREATOR = new Creator<EngagementConfiguration>()
  {
    @Override
    public EngagementConfiguration createFromParcel(Parcel in)
    {
      return new EngagementConfiguration(in);
    }

    @Override
    public EngagementConfiguration[] newArray(int size)
    {
      return new EngagementConfiguration[size];
    }
  };

  /** True serialized in Parcelable */
  private static final byte TRUE = Byte.MAX_VALUE;

  /** False serialized in Parcelable */
  private static final byte FALSE = 0;

  /**
   * Serialize a boolean for Parcelable.
   * @param value boolean to serialize.
   * @return byte value to use in Parcelable.
   */
  private static byte toByte(boolean value)
  {
    return value ? TRUE : FALSE;
  }

  /**
   * Parse a boolean from Parcelable.
   * @param value value to parse from Parcelable.
   * @return parsed boolean.
   */
  private static boolean toBoolean(byte value)
  {
    return value == TRUE;
  }

  /** Connection string */
  private String mConnectionString;

  /** Lazy area location report flag */
  private boolean mLazyAreaLocationReport;

  /** Real time location report flag */
  private boolean mRealtimeLocationReport;

  /** Fine real time location report flag */
  private boolean mFineRealtimeLocationReport;

  /** Background real time location report flag */
  private boolean mBackgroundRealtimeLocationReport;

  /** Custom device identifier to use */
  private String mDeviceId;

  /** Init. */
  public EngagementConfiguration()
  {
  }

  /**
   * Unmarshal a parcel.
   * @param in parcel.
   */
  private EngagementConfiguration(Parcel in)
  {
    mConnectionString = in.readString();
    mLazyAreaLocationReport = toBoolean(in.readByte());
    mRealtimeLocationReport = toBoolean(in.readByte());
    mFineRealtimeLocationReport = toBoolean(in.readByte());
    mBackgroundRealtimeLocationReport = toBoolean(in.readByte());
    mDeviceId = in.readString();
  }

  @Override
  public void writeToParcel(Parcel dest, int flags)
  {
    dest.writeString(mConnectionString);
    dest.writeByte(toByte(mLazyAreaLocationReport));
    dest.writeByte(toByte(mRealtimeLocationReport));
    dest.writeByte(toByte(mFineRealtimeLocationReport));
    dest.writeByte(toByte(mBackgroundRealtimeLocationReport));
    dest.writeString(mDeviceId);
  }

  @Override
  public int describeContents()
  {
    return 0;
  }

  /**
   * Get connection string.
   * @return connection string.
   */
  public String getConnectionString()
  {
    return mConnectionString;
  }

  /**
   * Set connection string.
   * @param connectionString connection string.
   */
  public void setConnectionString(String connectionString)
  {
    mConnectionString = connectionString;
  }

  /**
   * Get lazy area location report flag.
   * @return lazy area location report flag.
   */
  public boolean isLazyAreaLocationReport()
  {
    return mLazyAreaLocationReport;
  }

  /**
   * Set lazy area location report flag.
   * @param lazyAreaLocationReport lazy area location report flag.
   */
  public void setLazyAreaLocationReport(boolean lazyAreaLocationReport)
  {
    mLazyAreaLocationReport = lazyAreaLocationReport;
  }

  /**
   * Get real time location report flag.
   * @return real time location report flag.
   */
  public boolean isRealtimeLocationReport()
  {
    return mRealtimeLocationReport;
  }

  /**
   * Set real time location report flag.
   * @param realtimeLocationReport real time location report flag.
   */
  public void setRealtimeLocationReport(boolean realtimeLocationReport)
  {
    mRealtimeLocationReport = realtimeLocationReport;
  }

  /**
   * Get fine real time location report flag.
   * @return fine real time location report flag.
   */
  public boolean isFineRealtimeLocationReport()
  {
    return mFineRealtimeLocationReport;
  }

  /**
   * Set fine real time location report flag.
   * @param fineRealtimeLocationReport fine real time location report flag.
   */
  public void setFineRealtimeLocationReport(boolean fineRealtimeLocationReport)
  {
    mFineRealtimeLocationReport = fineRealtimeLocationReport;
  }

  /**
   * Get background real time location report flag.
   * @return background real time location report flag.
   */
  public boolean isBackgroundRealtimeLocationReport()
  {
    return mBackgroundRealtimeLocationReport;
  }

  /**
   * Set background real time location report flag.
   * @param backgroundRealtimeLocationReport background real time location report flag.
   */
  public void setBackgroundRealtimeLocationReport(boolean backgroundRealtimeLocationReport)
  {
    mBackgroundRealtimeLocationReport = backgroundRealtimeLocationReport;
  }

  /**
   * Get custom device identifier.
   * @return custom device identifier or null if not using a custom one.
   */
  public String getDeviceId()
  {
    return mDeviceId;
  }

  /**
   * Set a custom device identifier to use. If unspecified or null, the service will determine
   * device identifier automatically (strongly recommended). The device identifier must match the
   * [a-f0-9]{32} regular expression. The intended use is to set this configuration before the first
   * use of the agent for the current device. If you change the deviceId later, the data will be
   * inconsistent and is not a supported work flow. Use this method at your own risk.
   * @param deviceId custom device identifier to use.
   */
  public void setDeviceId(String deviceId)
  {
    this.mDeviceId = deviceId;
  }
}
