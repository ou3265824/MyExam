package com.myolq.myexam.exam;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.myolq.frame.Utils.AppUtils;
import com.myolq.myexam.R;
import com.myolq.myexam.base.InitFragment;
import com.myolq.myexam.ormlite.bean.JudgeBean;
import com.myolq.myexam.ormlite.bean.ManyBean;
import com.myolq.myexam.ormlite.dao.ManyDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/3/16.
 */

public class JudgeFragment extends InitFragment {


    @BindView(R.id.vp_pager)
    ViewPager vpPager;
    @BindView(R.id.tv_up)
    TextView tvUp;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_down)
    TextView tvDown;
    private ExamAdapter examAdapter;
    private List<View> views;
    private int current;
    private Handler handler;
    private List<JudgeBean> manyList;
    private ManyDao manyDao;
    private ManyActivity activity;
    private List<String> datas;


    @Override
    public int getLayout() {
        return R.layout.fragment_judge;
    }

    @Override
    public void onCreateView() {
        activity = (ManyActivity) getActivity();
        datas = new ArrayList<>();
        if (manyDao == null)
            manyDao = new ManyDao(AppUtils.appContext);
        if (manyList == null)
            manyList = new ArrayList<>();
        if (views == null)
            views = new ArrayList<>();
        if (examAdapter == null)
            examAdapter = new ExamAdapter(views);
        current = vpPager.getCurrentItem();
        setHandler();
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
                        manyList = ((List<JudgeBean>) msg.obj);
                        for (int i = 0; i < manyList.size(); i++) {
                            View view=getViewSingle(manyList.get(i));
                            views.add(view);
                            Map<Integer,View> map=new HashMap<>();
                            map.put(i,view);
//                            mapList.add(map);
                            datas.add("");
                        }

                        vpPager.setAdapter(examAdapter);
//                        for (int j = 0; j < views.size(); j++) {
//                            RadioGroup group= (RadioGroup)views.get(j).findViewById(R.id.rg_xuanze);
//                            final int finalJ = j;
//                            group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//                                @Override
//                                public void onCheckedChanged(RadioGroup group, int checkedId) {
//                                    //获取变更后的选中项的ID
//                                    int radioButtonId = group.getCheckedRadioButtonId();
//                                    //根据ID获取RadioButton的实例
//                                    RadioButton rb = (RadioButton) views.get(finalJ).findViewById(radioButtonId);
//                                    //更新文本内容，以符合选中项
//                                    ToastUtil.show(AppUtils.appContext,"您的性别是：" + rb.getText());
//                                    datas.set(finalJ,rb.getText()+"");
//                                }
//                            });
//                        }

                        break;
                }

            }
        };
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                List<ManyBean> singleList = manyDao.selectSingleList();
                Message message = new Message();
                message.what = 0;
                message.obj = singleList;
                handler.sendMessage(message);
            }
        };
        handler.post(runnable);
    }

    public View getViewSingle(JudgeBean judge) {
        View view = LayoutInflater.from(AppUtils.appContext).inflate(R.layout.view_judge, null);
        setinit(view, judge);
        return view;
    }

    public void setinit(View view,JudgeBean judge) {
        TextView tvTitleName = (TextView) view.findViewById(R.id.tv_title_name);
        final TextView tvResult = (TextView) view.findViewById(R.id.tv_result);
//            RadioGroup group = (RadioGroup) view.findViewById(R.id.rg_xuanze);
        AppCompatRadioButton rbA = (AppCompatRadioButton) view.findViewById(R.id.rb_a);
        AppCompatRadioButton rbB = (AppCompatRadioButton) view.findViewById(R.id.rb_b);
//        AppCompatRadioButton rbC = (AppCompatRadioButton) view.findViewById(R.id.rb_c);
//        AppCompatRadioButton rbD = (AppCompatRadioButton) view.findViewById(R.id.rb_d);
        if (judge != null) {
            tvTitleName.setText(judge.getTitleName());
            rbA.setText(judge.getOptionA());
            rbB.setText(judge.getOptionB());
//            if (CharacterUtils.isEmpty(activity.getType())&&activity.getType().equals("1")){
//                Bitmap bitmap=null;
//                cbA.setButtonDrawable(new BitmapDrawable(bitmap));
//                cbB.setButtonDrawable(new BitmapDrawable(bitmap));
//                cbC.setButtonDrawable(new BitmapDrawable(bitmap));
//                cbD.setButtonDrawable(new BitmapDrawable(bitmap));
//                tvResult.setText("答案：" + many.getResult());
//
//            }
            tvResult.setText("答案：" + judge.getResult());

        }

    }

}
