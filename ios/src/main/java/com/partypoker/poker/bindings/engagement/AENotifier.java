package com.partypoker.poker.bindings.engagement;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

/**
 * Created by sliubetskyi on 4/29/16.
 */
@NativeClass

/**
 * Custom notifier specification.
 *
 * You can define how a content notification is done for a set of categories by implementing this
 * protocol and registering your instances by calling <[AEReachModule registerNotifier:forCategory:]><br/>
 * It is recommended to extend the default implementation: <AEDefaultNotifier> which
 * performs most of the work and has convenient callbacks.
 */
//@protocol AENotifier <NSObject>
public interface AENotifier extends NSObjectProtocol {

    // @required

    /**
     * Handle a notification for a content.
     *
     * @param content content to be notified.
     * @result YES to accept the content, NO to postpone the content (like overlay disabled in a
     * specific context).
     */
    //- (BOOL)handleNotification:(AEInteractiveContent*)content;
    @Method(selector = "handleNotification:")
    boolean handleNotification(AEInteractiveContent content);

    /**
     * Reach module needs to control notification appearance.
     * When this method is called the notifier should clear any displayed notification for the given category.
     *
     * @param category the category to clear. This parameter can be ignored if the notifier handles only one kind of
     *                 category.
     */
    //- (void)clearNotification:(NSString*)category;
    @Method(selector = "clearNotification:")
    void clearNotification(String category);
    //@end
}
