package com.mycompany.myapp;

import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UIView;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBAction;
import org.robovm.objc.annotation.IBOutlet;

/**
 * Created by sliubetskyi on 3/22/16.
 */
@CustomClass("PushNotificationView")
public class PushNotificationView extends UIView {
    private UILabel uiLable;
    private UILabel uimessageLable;

    @IBOutlet
    public void setTitle(UILabel lable) {

        uiLable = lable;
    }

    @IBOutlet
    public void setMessage(UILabel lable) {
        uimessageLable = lable;
    }

    @IBAction
    public void closeBtnPressed () {

    }
}
