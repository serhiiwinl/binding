package com.partypoker.poker;

import com.partypoker.poker.bindings.engagement.EngagementAgent;
import com.partypoker.poker.others.AppUsageConfigInterface;
import com.partypoker.poker.others.BrandComponentFactory;
import com.partypoker.poker.others.State;
import com.partypoker.poker.others.tracking.PushNotification;
import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSBundle;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBAction;
import org.robovm.objc.annotation.IBOutlet;

@CustomClass("MyViewController")
public class MyViewController extends UIViewController implements State<MyViewController> {

    public static final String tag = MyViewController.class.getSimpleName();

    @IBOutlet
    private UILabel label;

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();
        BrandComponentFactory.getInstance().getAppUsageTracker().onAttachToApp(this);
    }

    @Override
    public void viewDidAppear(boolean b) {
        super.viewDidAppear(b);
        BrandComponentFactory.getInstance().getAppUsageTracker().onResume(this);
    }

    @Override
    public void viewDidDisappear(boolean b) {
        super.viewDidDisappear(b);
        BrandComponentFactory.getInstance().getAppUsageTracker().onPause(this);
    }

    @IBAction
    private void clicked() {
        EngagementAgent.shared().startActivity(getActivityName(), null);
        label.setText("Click Nr. " + 1);
    }

    public void showPushNotification(PushNotification pushNotification) {
        NSArray<?> viewList = NSBundle.getMainBundle().loadNib("PushNotificationView", null, null);
        PushNotificationView pushView = (PushNotificationView) viewList.get(0);
        pushView.setTitle(pushNotification.getTitle());
        pushView.setMessage(pushNotification.getMessage());
        this.getView().addSubview(pushView);
    }

    public AppUsageConfigInterface getAppConfig() {
        return new AppUsageConfigInterface();
    }

    @Override
    public MyViewController getActivity() {
        return this;
    }

    @Override
    public String getActivityName() {
        return tag;
    }
}
