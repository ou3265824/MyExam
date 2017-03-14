package com.myolq.frame.base;

import android.app.Application;

import com.myolq.frame.loader.OkgoLoader;

/**
 * Created by Administrator on 2017/3/14.
 */

public class BaseApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        OkgoLoader.getInstance().init(this);
    }
}
