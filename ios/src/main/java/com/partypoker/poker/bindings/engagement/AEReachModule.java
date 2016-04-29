package com.partypoker.poker.bindings.engagement;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIImage;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.ValuedEnum;

/**
 * Created by sliubetskyi on 4/27/16.
 */
@NativeClass
public class AEReachModule extends NSObject {

//    /* Export module name */
//    extern NSString* const kAEReachModuleName;
//
//    /* Export reach xml namespace */
//    extern NSString* const kAEReachNamespace;
//
//    /* Export reach default category */
//    extern NSString* const kAEReachDefaultCategory;

    /* Reach module state */
//    typedef enum _AEReachModuleState
//    {
//        AEReachModuleStateIdle = 1,
//        AEReachModuleStateNotifying = 2,
//        AEReachModuleStateLoading = 3,
//        AEReachModuleStateShowing = 4
//    } AEReachModuleState;

    public static enum AEReachModuleState implements ValuedEnum {
        AEReachModuleStateIdle(1),
        AEReachModuleStateNotifying(2),
        AEReachModuleStateLoading(3),
        AEReachModuleStateShowing(4);

        private final long n;
        private AEReachModuleState(long n) {
            this.n = n;
        }
        public long value() {
            return 0;
        }
    }

    /**
     * Instantiate a new reach Engagement module.
     * @param icon The image to use as the notification icon
     */
    //+ (id)moduleWithNotificationIcon:(UIImage*)icon;

    @Method(selector = "moduleWithNotificationIcon:")
    public static native AEReachModule moduleWithNotificationIcon(UIImage icon);

    /**
     * Register a notifier for a given category.
     * @param notifier Notifier to register for a category.
     * @param category The name of the category.
     */
    //- (void)registerNotifier:(id<AENotifier>)notifier forCategory:(NSString*)category;
    @Method(selector = "registerNotifier:forCategory:")
    public native void registerNotifier(AENotifier notifier, String category);

}
