package com.myolq.myexam.exam;

import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.myolq.myexam.R;
import com.myolq.myexam.base.InitActivity;

import butterknife.BindView;

public class ManyActivity extends InitActivity {

    @BindView(R.id.fl_layout)
    FrameLayout flLayout;

    public String getType() {
        return type;
    }

    private String type;

    @Override
    public int getLayout() {
        return R.layout.activity_many;
    }

    @Override
    public void onCreate() {
        type = getIntent().getStringExtra("type");
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        ManyFragment manyFragment=new ManyFragment();
        fragmentTransaction.add(R.id.fl_layout,manyFragment).commit();

    }

}
