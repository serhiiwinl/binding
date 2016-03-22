package com.mycompany.myapp;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSBundle;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UIView;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBAction;
import org.robovm.objc.annotation.IBOutlet;

@CustomClass("MyViewController")
public class MyViewController extends UIViewController {
    private static CounterStore counterStore = new CounterStore();

    @IBOutlet
    private UILabel label;


    @IBAction
    private void clicked() {
        showPushNotification ();
        counterStore.add(1);
        label.setText("Click Nr. " + counterStore.get());
    }

    public void showPushNotification () {
        NSArray<?> viewList = NSBundle.getMainBundle().loadNib("PushNotificationView", null, null);
        PushNotificationView pushView = (PushNotificationView) viewList.get(0);
//        PushNotificationView *notificationView = [PushNotificationView viewWithTitle:notification.title
//        andMessage:notification.message
//        andAppearancePosition:self.pushNotificationPosition];
//        CGFloat notificationViewYCoordinate;
//
//        if (self.pushNotificationPosition == PushNotificationAppearsFromTop) {
//            notificationViewYCoordinate = 0;
//        } else {
//            notificationViewYCoordinate = self.view.frame.size.height - notificationView.frame.size.height;
//        }
//
//        CGRect notificationViewFrame = CGRectMake(0,
//                notificationViewYCoordinate,
//                self.view.frame.size.width,
//                notificationView.frame.size.height);
//        notificationView.frame = notificationViewFrame;
//
//        [self.view addSubview:notificationView];
//
        this.getView().addSubview(pushView);
    }
}
