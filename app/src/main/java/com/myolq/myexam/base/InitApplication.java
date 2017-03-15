package com.myolq.myexam.base;

import android.app.Application;

import com.myolq.frame.NetConfig;
import com.myolq.frame.base.BaseApplication;
import com.myolq.frame.loader.OkgoLoader;
import com.myolq.myexam.greendao.GreenOpenHelper;

/**
 * Created by Administrator on 2017/3/14.
 */

public class InitApplication extends BaseApplication{

    @Override
    public void onCreate() {
        super.onCreate();
//        NetConfig.APIKEY_VALUE="94d6092f84c3b4415c223a4bc8f97473";
//        NetConfig.APPID_VALUE="68fdb2f573c1bcc79a6f206f85a936ff";
        GreenOpenHelper.getInstance().setupDatabase(this);
    }
}
