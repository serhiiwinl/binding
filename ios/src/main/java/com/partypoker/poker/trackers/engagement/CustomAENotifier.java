package com.partypoker.poker.trackers.engagement;

import com.partypoker.poker.bindings.engagement.AEDefaultNotifier;
import com.partypoker.poker.bindings.engagement.AEInteractiveContent;
import org.robovm.objc.annotation.CustomClass;

/**
 * Created by sliubetskyi on 4/29/16.
 */
public class CustomAENotifier extends AEDefaultNotifier {
    @Override
    public boolean handleNotification(AEInteractiveContent content) {
        return super.handleNotification(content);
    }

    @Override
    public void clearNotification(String category) {
        super.clearNotification(category);
    }
}
