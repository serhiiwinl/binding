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
    public void setTitle(String lable) {
        uiLable.setText(lable);
    }

    @IBOutlet
    public void setMessage(String lable) {
        uimessageLable.setText(lable);
    }

    @IBAction
    public void closeBtnPressed () {

    }
}
