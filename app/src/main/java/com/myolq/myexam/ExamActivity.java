package com.myolq.myexam;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.myolq.myexam.base.InitActivity;
import com.myolq.myexam.exam.ExamMuchFragment;
import com.myolq.myexam.exam.ExamOneFragment;

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
    private ExamOneFragment examOneFragment;
    private ExamMuchFragment examMuchFragment;
    private ExamAdapter examAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_exam;
    }


    @Override
    public void onCreate() {
        if (examOneFragment==null)
            examOneFragment = new ExamOneFragment();
        if (examMuchFragment==null)
            examMuchFragment = new ExamMuchFragment();
        List<Fragment> fragments=new ArrayList<>();
        examAdapter = new ExamAdapter(getSupportFragmentManager(),fragments);
        vpPager.setAdapter(examAdapter);
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
