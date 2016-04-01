package com.mycompany.myapp.others;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public class CommonInit {

    public CommonInit () {
        System.out.println(BrandComponentFactory.getInstance().getPlatform().getType());

    }
}
