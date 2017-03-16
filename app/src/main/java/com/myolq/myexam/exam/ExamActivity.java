package com.myolq.myexam.exam;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.myolq.myexam.R;
import com.myolq.myexam.base.InitActivity;
import com.myolq.myexam.ormlite.bean.SingleBean;
import com.myolq.myexam.ormlite.dao.SingleDao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ExamActivity extends InitActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.vp_pager)
    ViewPager vpPager;
    @BindView(R.id.tv_up)
    TextView tvUp;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_down)
    TextView tvDown;
    private SingleFragment examOneFragment;
    private ManyFragment examMuchFragment;
    private ExamAdapter examAdapter;
    private List<Fragment> fragments;

    @Override
    public int getLayout() {
        return R.layout.activity_exam;
    }


    @Override
    public void onCreate() {
        if (examOneFragment==null)
            examOneFragment = new SingleFragment();
        if (examMuchFragment==null)
            examMuchFragment = new ManyFragment();
        if (fragments==null)
            fragments = new ArrayList<>();
        if (examAdapter==null)
            examAdapter = new ExamAdapter(getSupportFragmentManager(), fragments);
        vpPager.setAdapter(examAdapter);

        SingleDao singleDao=new SingleDao(this);
        List<SingleBean> singleList=singleDao.selectSingleList();
        for (int i = 0; i < singleList.size(); i++) {
            fragments.add(examOneFragment);
        }

    }

    @OnClick({R.id.iv_back, R.id.tv_up, R.id.tv_down})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_up:
                break;
            case R.id.tv_down:
                break;
        }
    }
}
