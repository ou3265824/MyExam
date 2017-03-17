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

public class ExamAdapter extends PagerAdapter {

    List<View> views;

    public ExamAdapter(List<View> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
//			super.destroyItem(container, position, object);
    }

    //类似BaseAdapter中的getView
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.get(position);
        //细节:必须将view添加到container中
        container.addView(view);
        return view;
    }

}
