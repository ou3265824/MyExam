package com.myolq.myexam.exam;

import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.myolq.myexam.R;
import com.myolq.myexam.base.InitActivity;

import butterknife.BindView;

public class ManyActivity extends InitActivity {

    @BindView(R.id.fl_layout)
    FrameLayout flLayout;
    private ManyFragment manyFragment;
    private JudgeFragment judgeFragment;
    private SingleFragment singleFragment;
    private FragmentTransaction fragmentTransaction;


    private int type;

    public boolean isView() {
        return isView;
    }

    private boolean isView;

    @Override
    public int getLayout() {
        return R.layout.activity_many;
    }

    @Override
    public void onCreate() {
        type = getIntent().getIntExtra("type",0);
        isView = getIntent().getBooleanExtra("isView",false);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        getFragment();

    }

    private void getFragment() {
        hideFragment();
        if (type==1){
            if (singleFragment==null){
                singleFragment = new SingleFragment();
                fragmentTransaction.add(R.id.fl_layout, singleFragment);
            }else{
                fragmentTransaction.show(singleFragment);
            }
        }else if(type==2){
            if (manyFragment==null){
                manyFragment = new ManyFragment();
                fragmentTransaction.add(R.id.fl_layout,manyFragment);
            }else{
                fragmentTransaction.show(manyFragment);
            }
        }else if(type==3){
            if (judgeFragment==null){
                judgeFragment = new JudgeFragment();
                fragmentTransaction.add(R.id.fl_layout,judgeFragment);
            }else{
                fragmentTransaction.show(judgeFragment);
            }
        }
        fragmentTransaction.commit();
    }

    public void hideFragment(){
        if (singleFragment!=null){
            fragmentTransaction.hide(singleFragment);
        }else if (manyFragment!=null){
            fragmentTransaction.hide(manyFragment);
        }else if (judgeFragment!=null){
            fragmentTransaction.hide(judgeFragment);
        }
    }

}
