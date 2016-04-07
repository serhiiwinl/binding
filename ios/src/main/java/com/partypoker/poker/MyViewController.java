package com.partypoker.poker;

import com.partypoker.poker.others.tracking.PushNotification;
import com.partypoker.poker.trackers.impl.AppUsageTracker;
import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSBundle;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBAction;
import org.robovm.objc.annotation.IBOutlet;

@CustomClass("MyViewController")
public class MyViewController extends UIViewController {

    @IBOutlet
    private UILabel label;

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();
        AppUsageTracker.getInstance().onAttachToApp(this);
    }

    @IBAction
    private void clicked() {
        label.setText("Click Nr. " + 1);
    }

    public void showPushNotification(PushNotification pushNotification) {
        NSArray<?> viewList = NSBundle.getMainBundle().loadNib("PushNotificationView", null, null);
        PushNotificationView pushView = (PushNotificationView) viewList.get(0);
        pushView.setTitle(pushNotification.getTitle());
        pushView.setMessage(pushNotification.getMessage());
        this.getView().addSubview(pushView);
    }
}
