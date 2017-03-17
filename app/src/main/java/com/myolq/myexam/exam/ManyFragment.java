package com.myolq.myexam.exam;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.myolq.frame.Utils.AppUtils;
import com.myolq.frame.Utils.L;
import com.myolq.myexam.R;
import com.myolq.myexam.base.InitFragment;
import com.myolq.myexam.ormlite.bean.ManyBean;
import com.myolq.myexam.ormlite.dao.ManyDao;
import com.myolq.myexam.utils.DialogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

import static android.R.attr.data;
import static android.media.CamcorderProfile.get;

/**
 * Created by Administrator on 2017/3/14.
 */

public class ManyFragment extends InitFragment {


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
    private List<ManyBean> manyList;
    private ManyDao manyDao;
    private ManyActivity activity;
    private List<String> datas;
    private List<Map<String, String>> daanList;


    @Override
    public int getLayout() {
        return R.layout.fragment_many;
    }

    @Override
    public void onCreateView() {
        activity = (ManyActivity) getActivity();
        datas = new ArrayList<>();
        daanList = new ArrayList<>();
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
                        manyList = ((List<ManyBean>) msg.obj);
                        for (int i = 0; i < manyList.size(); i++) {
                            View view = getViewSingle(manyList.get(i));
                            views.add(view);
//                            Map<Integer,View> map=new HashMap<>();
//                            map.put(i,view);
//                            mapList.add(map);
                            daanList.add(new HashMap<String, String>());
                        }

                        vpPager.setAdapter(examAdapter);

                        for (int j = 0; j < views.size(); j++) {
                            CheckBox cbA = (CheckBox) views.get(j).findViewById(R.id.cb_a);
                            CheckBox cbB = (CheckBox) views.get(j).findViewById(R.id.cb_b);
                            CheckBox cbC = (CheckBox) views.get(j).findViewById(R.id.cb_c);
                            CheckBox cbD = (CheckBox) views.get(j).findViewById(R.id.cb_d);
                            final CheckBox[] cbs = new CheckBox[]{cbA, cbB, cbC, cbD};
                            for (int i = 0; i < cbs.length; i++) {
                                final int finalJ = j;
                                cbs[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                    @Override
                                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                                        Map<String, String> map = new HashMap<String, String>();
//                                        if (b) {
                                            if (cbs[0].isChecked()) {
                                                map.put("opA", "A");
                                            } else {
                                                map.remove("opA");
                                            }
                                            if (cbs[1].isChecked()) {
                                                map.put("opB", "B");
                                            } else {
                                                map.remove("opB");
                                            }
                                            if (cbs[2].isChecked()) {
                                                map.put("opC", "C");
                                            } else {
                                                map.remove("opC");
                                            }
                                            if (cbs[3].isChecked()) {
                                                map.put("opD", "D");
                                            } else {
                                                map.remove("opD");
                                            }
                                            daanList.set(finalJ, map);
//                                        }else{
//
//                                        }
                                    }
                                });
                            }
                        }

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

    public View getViewSingle(ManyBean many) {
        View view = LayoutInflater.from(AppUtils.appContext).inflate(R.layout.view_many, null);
        setinit(view, many);
        return view;
    }

    public void setinit(View view, ManyBean many) {
        TextView tvTitleName = (TextView) view.findViewById(R.id.tv_title_name);
        final TextView tvResult = (TextView) view.findViewById(R.id.tv_result);
//            RadioGroup group = (RadioGroup) view.findViewById(R.id.rg_xuanze);
        CheckBox cbA = (CheckBox) view.findViewById(R.id.cb_a);
        CheckBox cbB = (CheckBox) view.findViewById(R.id.cb_b);
        CheckBox cbC = (CheckBox) view.findViewById(R.id.cb_c);
        CheckBox cbD = (CheckBox) view.findViewById(R.id.cb_d);
        if (many != null) {
            tvTitleName.setText(many.getTitleName());
            cbA.setText(many.getOptionA());
            cbB.setText(many.getOptionB());
            cbC.setText(many.getOptionC());
            cbD.setText(many.getOptionD());
            if (activity.isView()) {
                Bitmap bitmap = null;
                cbA.setButtonDrawable(new BitmapDrawable(bitmap));
                cbB.setButtonDrawable(new BitmapDrawable(bitmap));
                cbC.setButtonDrawable(new BitmapDrawable(bitmap));
                cbD.setButtonDrawable(new BitmapDrawable(bitmap));
                tvResult.setText("答案：" + many.getResult());

            }

            tvResult.setText("答案：" + many.getResult());

        }

    }


    @OnClick({R.id.tv_jiaojuan, R.id.tv_up, R.id.tv_down})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_jiaojuan:
                double grade=0;
                for (int j = 0; j < views.size(); j++) {

                    L.log(daanList.get(j)+"-----"+manyList.get(j).getResult());
                    Map<String,String> map=daanList.get(j);
                    String[] daans=new String[4];
                    if (map.get("opA")!=null){
                        daans[0]="A";
                    }
                    if (map.get("opB")!=null){
                        daans[1]="B";
                    }
                    if (map.get("opC")!=null){
                        daans[2]="C";
                    }
                    if (map.get("opD")!=null){
                        daans[3]="D";
                    }
                    String[] result=manyList.get(j).getResult().split(",");
                    for (int i = 0; i < result.length; i++) {
                        for (int k = 0; k < daans.length; k++){
                            if (result[i].equals(daans[k])){
                                L.log("对:"+manyList.get(j).getFraction());
                                grade+= Double.parseDouble(manyList.get(j).getFraction());
                            }
                        }
                    }
                }

                DialogUtils.createAlertDialog(getActivity(), "分数","你考了" + grade + "分", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        getActivity().finish();
                    }
                });
                break;
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
        }
    }
}
