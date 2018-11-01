package com.example.zrgl.zhrglshopping.ui.util;

import android.app.Application;
import android.content.Context;

public class NetApplication extends Application {
    private static NetApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;

    }
    /**获取上下文*/
    public static Context getApplication() {
        return application;
    }
}
