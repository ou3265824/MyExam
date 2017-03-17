package com.myolq.myexam.exam;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.myolq.frame.Utils.AppUtils;
import com.myolq.frame.Utils.L;
import com.myolq.frame.Utils.TimeUtils;
import com.myolq.frame.Utils.ToastUtil;
import com.myolq.myexam.R;
import com.myolq.myexam.base.InitActivity;
import com.myolq.myexam.ormlite.bean.SingleBean;
import com.myolq.myexam.ormlite.dao.SingleDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.data;
import static android.R.attr.fragment;
import static android.R.attr.type;
import static android.R.id.list;
import static android.media.CamcorderProfile.get;
import static com.tencent.bugly.crashreport.crash.c.g;
import static com.tencent.bugly.crashreport.crash.c.i;
import static com.tencent.bugly.crashreport.crash.c.m;

public class ExamActivity extends InitActivity {


    @BindView(R.id.vp_pager)
    ViewPager vpPager;
    @BindView(R.id.tv_up)
    TextView tvUp;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_down)
    TextView tvDown;


    private ExamAdapter examAdapter;
    private List<Fragment> fragments;
    private List<View> views;
    private SingleDao singleDao;
    private Handler handler;
    private List<SingleBean> singleList;
    private SingleFragment singleFragment;
    private int current = 0;
    private AppCompatRadioButton rbA;
    private AppCompatRadioButton rbB;
    private AppCompatRadioButton rbC;
    private AppCompatRadioButton rbD;
    private List<Map<Integer, View>> mapList;
    private List<String> daans;
    private Runnable runtime;
    private Handler handlertime;
    private String type;


    @Override
    public int getLayout() {
        return R.layout.activity_exam;
    }


    @Override
    public void onCreate() {
        type = getIntent().getStringExtra("type");
        mapList = new ArrayList<>();
        daans = new ArrayList<>();
        if (singleFragment == null) {
            singleFragment = new SingleFragment();
        }
        if (fragments == null)
            fragments = new ArrayList<>();
        if (views == null)
            views = new ArrayList<>();
        if (singleList == null)
            singleList = new ArrayList<>();
        if (examAdapter == null)
            examAdapter = new ExamAdapter(getSupportFragmentManager(), fragments);
//        vpPager.setAdapter(examAdapter);
        singleDao = new SingleDao(this);
        setTime();
        setHandler();
        current = vpPager.getCurrentItem();
        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                current = position;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    public void setHandler() {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        singleList = ((List<SingleBean>) msg.obj);
                        for (int i = 0; i < singleList.size(); i++) {
                            fragments.add(singleFragment);
                            View view=getViewSingle(singleList.get(i));
                            views.add(view);
                            Map<Integer,View> map=new HashMap<>();
                            map.put(i,view);
                            mapList.add(map);
                            daans.add("");
                        }

                        MyAdapter myAdapter = new MyAdapter();
                        vpPager.setAdapter(myAdapter);
                        for (int j = 0; j < mapList.size(); j++) {
                           RadioGroup group= (RadioGroup) mapList.get(j).get(j).findViewById(R.id.rg_xuanze);
                            final int finalJ = j;
                            group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(RadioGroup group, int checkedId) {
                                    //获取变更后的选中项的ID
                                    int radioButtonId = group.getCheckedRadioButtonId();
                                    //根据ID获取RadioButton的实例
                                    RadioButton rb = (RadioButton) mapList.get(finalJ).get(finalJ).findViewById(radioButtonId);
                                    //更新文本内容，以符合选中项
                                    ToastUtil.show(AppUtils.appContext,"您的性别是：" + rb.getText());
                                    daans.set(finalJ,rb.getText()+"");
                                }
                            });
                        }

                        break;
                }

            }
        };
        Runnable runnable = new Runnable() {
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
    int time=60*60;
    public void setTime() {
        handlertime = new Handler();
        runtime = new Runnable() {
            @Override
            public void run() {
//                int time=60*60;
                time--;
                tvTime.setText(TimeUtils.secondFormatHms(time)+"");
                handler.postDelayed(runtime,1000);
            }
        };
        handlertime.post(runtime);
    }


    public SingleBean getSingle() {

        return singleList != null ? singleList.get(current) : null;
    }

    public View getViewSingle(SingleBean single) {
        View view = getLayoutInflater().inflate(R.layout.fragment_single, null);
        setinit(view, single);
        return view;
    }

    public void setinit(View view,SingleBean single) {
            TextView tvTitleName = (TextView) view.findViewById(R.id.tv_title_name);
            final TextView tvResult = (TextView) view.findViewById(R.id.tv_result);
//            RadioGroup group = (RadioGroup) view.findViewById(R.id.rg_xuanze);
            rbA = (AppCompatRadioButton) view.findViewById(R.id.rb_a);
            rbB = (AppCompatRadioButton) view.findViewById(R.id.rb_b);
            rbC = (AppCompatRadioButton) view.findViewById(R.id.rb_c);
            rbD = (AppCompatRadioButton) view.findViewById(R.id.rb_d);
            if (single != null) {
                tvTitleName.setText(single.getTitleName());
                rbA.setText(single.getOptionA());
                rbB.setText(single.getOptionB());
                rbC.setText(single.getOptionC());
                rbD.setText(single.getOptionD());
                if (type.equals("1")){
                    rbA.setButtonDrawable(null);
                    rbB.setButtonDrawable(null);
                    rbC.setButtonDrawable(null);
                    rbD.setButtonDrawable(null);
                    tvResult.setText("答案：" + single.getResult());
                }


        }

    }


    @OnClick({ R.id.tv_up, R.id.tv_down, R.id.tv_jiaojuan})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_up:
                if (current>0){
                    current--;
                    vpPager.setCurrentItem(current);
                }
                break;
            case R.id.tv_down:
                    current++;
                vpPager.setCurrentItem(current);
                break;
            case R.id.tv_jiaojuan:
                double grade=0;
                for (int j = 0; j < views.size(); j++) {
                    L.log(daans.get(j)+"-----"+singleList.get(j).getResult());
                    if (daans.get(j).startsWith(singleList.get(j).getResult())) {

                        L.log(grade+"-----"+singleList.get(j).getFraction());
                        grade+= Double.parseDouble(singleList.get(j).getFraction());

                    }
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("分数");
                builder.setMessage("你考了"+grade+"分");
                AlertDialog dialog=builder.create();
                dialog.setCancelable(false);
                dialog.show();
                builder.setNeutralButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        finish();
                    }
                });
                break;
        }
    }

    class MyAdapter extends PagerAdapter {

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

}
