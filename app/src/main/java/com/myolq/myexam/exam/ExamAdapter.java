package com.myolq.myexam.exam;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myolq.myexam.R;
import com.myolq.myexam.ormlite.bean.SingleBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.media.CamcorderProfile.get;

/**
 * Created by Administrator on 2017/3/14.
 */

public class ExamAdapter extends FragmentPagerAdapter {


    private List<Fragment> views;

    public ExamAdapter(FragmentManager fm,List<Fragment> views) {
        super(fm);
        this.views=views;
    }


    @Override
    public int getCount() {
        return views == null ? 0 : views.size();
    }


    @Override
    public Fragment getItem(int position) {
        return views.get(position);
    }
}
