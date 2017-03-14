package com.myolq.myexam;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */

public class ExamAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragments;

    public ExamAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
