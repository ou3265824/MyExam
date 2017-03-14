package com.myolq.myexam.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myolq.frame.base.BaseFragment;

/**
 * Created by Administrator on 2017/3/14.
 */

public abstract class InitFragment extends BaseFragment{

    public abstract void onCreateView();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=super.onCreateView(inflater, container, savedInstanceState);
        onCreateView();
        return view;
    }
}
