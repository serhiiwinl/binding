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

/**
 * Reach module. <br/>
 * Here are the steps to integrate Reach in your application: <br/>
 * <ul>
 * <li>Integrate the Reach activities:
 * <ul>
 * <li>{@link com.microsoft.azure.engagement.reach.activity.EngagementTextAnnouncementActivity}</li>
 * <li>{@link com.microsoft.azure.engagement.reach.activity.EngagementWebAnnouncementActivity}</li>
 * <li>{@link com.microsoft.azure.engagement.reach.activity.EngagementPollActivity}</li>
 * <li>{@link com.microsoft.azure.engagement.reach.activity.EngagementLoadingActivity}</li>
 * </ul>
 * </li>
 * <li>Integrate the Reach broadcast receiver:
 * {@link com.microsoft.azure.engagement.reach.EngagementReachReceiver}</li>
 * <li>Copy the files in the <tt>res/reach/layout</tt> folder delivered with the SDK into the
 * <tt>res/layout</tt> folder of your application.</li>
 * <li>Copy the files in the <tt>res/reach/drawable</tt> folder delivered with the SDK into the
 * <tt>res/drawable</tt> folder of your application.</li>
 * </ul>
 * Some configuration is done in the AndroidManifest.xml file thanks to meta-data section to put
 * as a child of the <tt>application</tt> tag:
 * <ul>
 * <li>Mandatory: Notification icon (48*48 pixels):
 * {@code <meta-data android:name="engagement:reach:notification:icon" android:value="<icon_resource_name>"/>}
 * </li>
 * </ul>
 * If you want to enable sound or vibration for system notifications you need the following
 * permission: {@code <uses-permission android:name="android.permission.VIBRATE" />}.<br/>
 * For notifications with big picture, you also need:
 * <ul>
 * <li>{@code <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>}.</li>
 * <li>{@code <uses-permission android:name="android.permission.DOWNLOAD_WITHOUT_NOTIFICATION"/>}.
 * </li>
 * </ul>
 */
package com.partypoker.poker.engagement.reach;