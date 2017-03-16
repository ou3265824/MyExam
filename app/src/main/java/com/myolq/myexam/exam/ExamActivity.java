package com.myolq.myexam.exam;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myolq.frame.Utils.AppUtils;
import com.myolq.frame.Utils.L;
import com.myolq.myexam.R;
import com.myolq.myexam.base.InitActivity;
import com.myolq.myexam.ormlite.bean.SingleBean;
import com.myolq.myexam.ormlite.dao.SingleDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.data;
import static android.R.attr.fragment;

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


    private ExamAdapter examAdapter;
    private List<Fragment> views;
    private SingleDao singleDao;
    private Handler handler;
    private List<SingleBean> singleList;
    private SingleFragment singleFragment;
    private int current=0;

    @Override
    public int getLayout() {
        return R.layout.activity_exam;
    }


    @Override
    public void onCreate() {
        if (singleFragment==null){
            singleFragment = new SingleFragment();
        }
        if (views == null)
            views = new ArrayList<>();
        if (singleList == null)
            singleList = new ArrayList<>();
        if (examAdapter == null)
            examAdapter=new ExamAdapter(getSupportFragmentManager(),views);
        vpPager.setAdapter(examAdapter);
        singleDao = new SingleDao(this);

        setHandler();
        current = vpPager.getCurrentItem();
        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                current=position;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



    public void setHandler(){
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case 0:
                        singleList.addAll((List<SingleBean>) msg.obj);
                        for (int i = 0; i <singleList.size() ; i++) {
                            views.add(singleFragment);
                        }
                        break;
                }

            }
        };
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                List<SingleBean> singleList = singleDao.selectSingleList();
                Message message = new Message();
                message.what = 0;
                message.obj = singleList;
                handler.sendMessage(message);
            }
        };
        handler.post(runnable);
    }



    public SingleBean getSingle(){

       return singleList!=null?singleList.get(current):null;
    }

    public View getViewSingle(SingleBean single) {
        View view = getLayoutInflater().inflate(R.layout.fragment_single, null);
        setinit(view,single);
        return view;
    }
    public void setinit(View view,SingleBean single){
        TextView tvTitleName= (TextView) view.findViewById(R.id.tv_title_name);
        TextView tvResult= (TextView) view.findViewById(R.id.tv_result);
        AppCompatRadioButton rbA= (AppCompatRadioButton) view.findViewById(R.id.rb_a);
        AppCompatRadioButton rbB= (AppCompatRadioButton) view.findViewById(R.id.rb_b);
        AppCompatRadioButton rbC= (AppCompatRadioButton) view.findViewById(R.id.rb_c);
        AppCompatRadioButton rbD= (AppCompatRadioButton) view.findViewById(R.id.rb_d);
        if (single!=null){
            tvTitleName.setText(single.getTitleName());
            rbA.setText(single.getOptionA());
            rbB.setText(single.getOptionB());
            rbC.setText(single.getOptionC());
            rbD.setText(single.getOptionD());
            tvResult.setText(single.getResult());
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
