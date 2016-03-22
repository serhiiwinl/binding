package com.mycompany.myapp;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public class CommonInit {

    public CommonInit () {
        System.out.println(Factory.getInstance().getPlatform().getType());


    }
}
