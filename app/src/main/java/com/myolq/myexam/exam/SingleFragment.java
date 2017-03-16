package com.myolq.myexam.exam;

import android.support.v7.widget.AppCompatRadioButton;
import android.widget.TextView;

import com.myolq.frame.Utils.AppUtils;
import com.myolq.myexam.R;
import com.myolq.myexam.base.InitFragment;
import com.myolq.myexam.ormlite.bean.SingleBean;
import com.myolq.myexam.ormlite.dao.SingleDao;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/3/14.
 */

public class SingleFragment extends InitFragment {
    @BindView(R.id.tv_title_name)
    TextView tvTitleName;
    @BindView(R.id.rb_a)
    AppCompatRadioButton rbA;
    @BindView(R.id.rb_b)
    AppCompatRadioButton rbB;
    @BindView(R.id.rb_c)
    AppCompatRadioButton rbC;
    @BindView(R.id.rb_d)
    AppCompatRadioButton rbD;
    @BindView(R.id.tv_result)
    TextView tvResult;

    @Override
    public int getLayout() {
        return R.layout.fragment_single;
    }

    @Override
    public void onCreateView() {
        ExamActivity activity= (ExamActivity) getActivity();
        SingleBean single=activity.getSingle();
        if (single!=null){
            tvTitleName.setText(single.getTitleName());
            rbA.setText(single.getOptionA());
            rbB.setText(single.getOptionB());
            rbC.setText(single.getOptionC());
            rbD.setText(single.getOptionD());
            tvResult.setText(single.getResult());
        }
    }
}
