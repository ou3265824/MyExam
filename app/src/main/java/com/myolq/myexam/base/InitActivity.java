package com.myolq.myexam.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.myolq.frame.base.BaseActivity;

/**
 * Created by Administrator on 2017/3/14.
 */

public abstract class InitActivity extends BaseActivity{

    public abstract void onCreate();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        onCreate();
    }
}
