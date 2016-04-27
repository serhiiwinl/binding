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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONStringer;

import android.os.Bundle;

/**
 * Utility class to convert an Android {@link Bundle Bundle} into a JSON string: numbers,
 * boolean, strings, arrays (and {@link ArrayList ArrayList}) are converted into the
 * proper JSON format. Bundles are supported, e.g. a deep conversion is performed. {@link Throwable}
 * object are formatted like in the console. {@link android.os.Parcelable Parcelable},
 * {@link java.io.Serializable Serializable} and {@link android.util.SparseArray SparseArray} are
 * formatted according to their {@link #toString()} implementation (so it's totally useless to use a
 * SparseArray since {@link #toString()} is not overridden in it}.
 */
public class EngagementBundleToJSON
{
  /**
   * Write an Android {@link Bundle Bundle} as a JSON string.
   * @param bundle the Bundle to convert into JSON.
   * @return the JSON object representing the Bundle as a String.
   * @throws IllegalArgumentException if bundle is null.
   */
  public static String toString(Bundle bundle) throws IllegalArgumentException
  {
    /* Throw an exception if bundle is null */
    if (bundle == null)
      throw new IllegalArgumentException("bundle can not be null");

    /* Launch JSON serializer */
    JSONStringer json = new JSONStringer();
    try
    {
      convert(json, bundle);
    }
    catch (JSONException jsone)
    {
      /* Ignore this key */
    }

    /* Return the JSON string */
    return json.toString();
  }

  /**
   * Recursive function to write a value to JSON.
   * @param json the JSON serializer.
   * @param value the value to write in JSON.
   */
  private static void convert(JSONStringer json, Object value) throws JSONException
  {
    /* Handle null */
    if (value == null)
      json.value(null);

    /* The function is recursive if it encounters a bundle */
    else if (value instanceof Bundle)
    {
      /* Cast bundle */
      Bundle bundle = (Bundle) value;

      /* Open object */
      json.object();

      /* Traverse bundle */
      for (String key : bundle.keySet())
      {
        /* Write key */
        json.key(key);

        /* Recursive call to write the value */
        convert(json, bundle.get(key));
      }

      /* End object */
      json.endObject();
    }

    /* Handle array, write it as a JSON array */
    else if (value.getClass().isArray())
    {
      /* Open array */
      json.array();

      /* Recursive call on each value */
      int length = Array.getLength(value);
      for (int i = 0; i < length; i++)
        convert(json, Array.get(value, i));

      /* Close array */
      json.endArray();
    }

    /* Handle ArrayList, write it as a JSON array */
    else if (value instanceof ArrayList<?>)
    {
      /* Open array */
      json.array();

      /* Recursive call on each value */
      ArrayList<?> arrayList = (ArrayList<?>) value;
      for (Object val : arrayList)
        convert(json, val);

      /* Close array */
      json.endArray();
    }

    /* Format throwable values with the stack trace */
    else if (value instanceof Throwable)
    {
      Throwable t = (Throwable) value;
      StringWriter text = new StringWriter();
      t.printStackTrace(new PrintWriter(text));
      json.value(text.toString());
    }

    /* Other values are handled directly by JSONStringer (numerical, boolean and String) */
    else
      json.value(value);
  }
}
