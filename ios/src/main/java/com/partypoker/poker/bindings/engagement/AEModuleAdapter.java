package com.partypoker.poker.bindings.engagement;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NotImplemented;

/**
 * Created by sliubetskyi on 4/21/16.
 */
public class AEModuleAdapter extends NSObject implements AEModule {
    @Override
    @NotImplemented("start:")
    public void start() {

    }

    @Override
    @NotImplemented("stop:")
    public void stop() {

    }

    @Override
    @NotImplemented("name:")
    public String name() {
        return null;
    }

    @Override
    @NotImplemented("pushMessageReceived:")
    public void pushMessageReceived(AEPushMessage msg) {

    }

    @Override
    @NotImplemented("processRemoteNotification:")
    public void processRemoteNotification(NSDictionary<?, ?> userInfo) {

    }

    @Override
    @NotImplemented("dlcDownloaded:")
    public void dlcDownloaded(AEPushMessage message) {

    }

    @Override
    @NotImplemented("start:")
    public void dlcDownloadFailed(String messageId) {

    }

    @Override
    @NotImplemented("campaignsPolled:")
    public void campaignsPolled(NSArray<?> campaigns) {

    }

    @Override
    @NotImplemented("campaignsPollFailed:")
    public void campaignsPollFailed() {

    }

    @Override
    @NotImplemented("activityChanged:")
    public void activityChanged(String activityName) {

    }

    @Override
    @NotImplemented("pushNotificationReceived:")
    public void pushNotificationReceived(NSDictionary<?, ?> notification) {

    }

    @Override
    @NotImplemented("configurationChanged:")
    public void configurationChanged() {

    }
}
