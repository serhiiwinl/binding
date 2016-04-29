package com.partypoker.poker.bindings.engagement;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NotImplemented;

/**
 * Created by sliubetskyi on 4/29/16.
 */
public class AENotifierAdapter extends NSObject implements AENotifier {

    @Override
    @NotImplemented("handleNotification:")
    public boolean handleNotification(AEInteractiveContent content) {
        return false;
    }

    @Override
    @NotImplemented("clearNotification:")
    public void clearNotification(String category) {}
}
