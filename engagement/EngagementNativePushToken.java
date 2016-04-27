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

import java.util.Locale;

import android.os.Parcel;
import android.os.Parcelable;

/** Native push registration with Engagement */
public class EngagementNativePushToken implements Parcelable
{
  /** Native push service type */
  public enum Type
  {
    GCM,
    ADM;

    @Override
    public String toString()
    {
      return name().toLowerCase(Locale.US);
    };
  }

  /** Parcelable factory */
  public static final Creator<EngagementNativePushToken> CREATOR = new Creator<EngagementNativePushToken>()
  {
    @Override
    public EngagementNativePushToken createFromParcel(Parcel in)
    {
      return new EngagementNativePushToken(in);
    }

    @Override
    public EngagementNativePushToken[] newArray(int size)
    {
      return new EngagementNativePushToken[size];
    }
  };

  /** Token value (registration identifier) */
  private final String token;

  /** Token type */
  private final Type type;

  /**
   * Init.
   * @param token registration identifier.
   * @param type service type.
   */
  public EngagementNativePushToken(String token, Type type)
  {
    this.token = token;
    this.type = type;
  }

  /**
   * Unmarshal a parcel.
   * @param in parcel.
   */
  private EngagementNativePushToken(Parcel in)
  {
    token = in.readString();
    type = typeFromInt(in.readInt());
  }

  /**
   * Get token value.
   * @return token value.
   */
  public String getToken()
  {
    return token;
  }

  /**
   * Get token native push service type.
   * @return token native push service type.
   */
  public Type getType()
  {
    return type;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags)
  {
    dest.writeString(token);
    dest.writeInt(type == null ? -1 : type.ordinal());
  }

  @Override
  public int describeContents()
  {
    return 0;
  }

  /**
   * Get token type from integer (enum ordinal).
   * @param ordinal enum ordinal.
   * @return token type, or null if ordinal is invalid.
   */
  public static Type typeFromInt(int ordinal)
  {
    Type[] values = Type.values();
    return ordinal >= 0 && ordinal < values.length ? values[ordinal] : null;
  }
}
