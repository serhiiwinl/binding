package com.mycompany.myapp;

import com.mycompany.myapp.trackers.PushNotification;
import com.mycompany.myapp.trackers.otherlevels.IOSOtherLevelsTracker;
import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSBundle;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBAction;
import org.robovm.objc.annotation.IBOutlet;

@CustomClass("MyViewController")
public class MyViewController extends UIViewController {
    private static CounterStore counterStore = new CounterStore();

    @IBOutlet
    private UILabel label;

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();
        //TODO:Factory get appUsageTracker
        //IOSOtherLevelsTracker.getInstance().onAttachToApp(this);
    }

    @IBAction
    private void clicked() {
        counterStore.add(1);
        label.setText("Click Nr. " + counterStore.get());
    }

    public void showPushNotification(PushNotification pushNotification) {
        NSArray<?> viewList = NSBundle.getMainBundle().loadNib("PushNotificationView", null, null);
        PushNotificationView pushView = (PushNotificationView) viewList.get(0);
        pushView.setTitle(pushNotification.getTitle());
        pushView.setMessage(pushNotification.getMessage());
        this.getView().addSubview(pushView);
    }
}
