package com.myolq.myexam;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

import com.google.gson.reflect.TypeToken;
import com.myolq.frame.callback.GsonCallBack;
import com.myolq.frame.loader.OkgoLoader;
import com.myolq.myexam.base.InitActivity;
import com.myolq.myexam.bean.BaseBean;
import com.myolq.myexam.exam.ExamActivity;
import com.myolq.myexam.exam.ManyActivity;
import com.myolq.myexam.ormlite.bean.JudgeBean;
import com.myolq.myexam.ormlite.bean.ManyBean;
import com.myolq.myexam.ormlite.bean.SingleBean;
import com.myolq.myexam.ormlite.dao.JudgeDao;
import com.myolq.myexam.ormlite.dao.ManyDao;
import com.myolq.myexam.ormlite.dao.SingleDao;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class HomeActivity extends InitActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rb_single)
    RadioButton rbSingle;
    @BindView(R.id.rb_single_exam)
    RadioButton rbSingleExam;
    @BindView(R.id.rb_many)
    RadioButton rbMany;
    @BindView(R.id.rb_many_exam)
    RadioButton rbManyExam;
    @BindView(R.id.rb_judge)
    RadioButton rbJudge;
    @BindView(R.id.rb_judge_exam)
    RadioButton rbJudgeExam;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private SingleDao singleDao;
    private ManyDao manyDao;
    private JudgeDao judgeDao;

    @Override
    public int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void onCreate() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        singleDao = new SingleDao(this);
        manyDao = new ManyDao(this);
        judgeDao = new JudgeDao(this);
        getSingle();
        getMany();
        getJudge();
    }



    private void getSingle() {
        if (singleDao.selectMax() != null) {
            String where = "{\"updatedAt\":{\"$gt\":\"" + singleDao.selectMax() + "\"}}";
//            String where="%7B\"updatedAt\":%7B\"$gt\":\""+singleDao.selectMax()+"\"%7D%7D";
            OkgoLoader.getInstance().sendByGet(BaseUrl.SINGLE + "?where=" + where, new GsonCallBack<BaseBean<SingleBean>>(new TypeToken<BaseBean<SingleBean>>() {
            }.getType()) {
                @Override
                public void onSuccess(BaseBean<SingleBean> baseBean, Call call, Response response) {
                    List<SingleBean> list = baseBean.getResults();
                    SingleDao singledao = new SingleDao(getApplicationContext());
                    singledao.add(list);
                }

                @Override
                public void onError(Call call, Response response, Exception e) {

                }
            });
        } else {
            OkgoLoader.getInstance().sendByGet(BaseUrl.SINGLE, new GsonCallBack<BaseBean<SingleBean>>(new TypeToken<BaseBean<SingleBean>>() {
            }.getType()) {
                @Override
                public void onSuccess(BaseBean<SingleBean> baseBean, Call call, Response response) {
                    List<SingleBean> list = baseBean.getResults();
                    SingleDao singledao = new SingleDao(getApplicationContext());
                    singledao.add(list);
                }

                @Override
                public void onError(Call call, Response response, Exception e) {

                }
            });
        }
    }

    //{"updateAt":{"$gt":"+singleDao.selectMax()+"}}
    private void getMany() {
        if (singleDao.selectMax() != null) {
//            String where="%7B\"titleId\":%7B\"$gt\":"+3+"%7D%7D";
            String where = "{\"updatedAt\":{\"$gt\":\"" + singleDao.selectMax() + "\"}}";
//            String where="%7B\"updatedAt\":%7B\"$gt\":\""+singleDao.selectMax()+"\"%7D%7D";
            OkgoLoader.getInstance().sendByGet(BaseUrl.MANY + "?where=" + where, new GsonCallBack<BaseBean<ManyBean>>(new TypeToken<BaseBean<ManyBean>>() {
            }.getType()) {
                @Override
                public void onSuccess(BaseBean<ManyBean> baseBean, Call call, Response response) {
                    List<ManyBean> list = baseBean.getResults();
                    ManyDao manyDao = new ManyDao(getApplicationContext());
                    manyDao.add(list);
//                    L.log(baseBean.g());
                }

                @Override
                public void onError(Call call, Response response, Exception e) {

                }
            });
        } else {
            OkgoLoader.getInstance().sendByGet(BaseUrl.MANY, new GsonCallBack<BaseBean<ManyBean>>(new TypeToken<BaseBean<ManyBean>>() {
            }.getType()) {
                @Override
                public void onSuccess(BaseBean<ManyBean> baseBean, Call call, Response response) {
                    List<ManyBean> list = baseBean.getResults();
                    ManyDao manyDao = new ManyDao(getApplicationContext());
                    manyDao.add(list);
                }

                @Override
                public void onError(Call call, Response response, Exception e) {

                }
            });
        }
    }

    private void getJudge() {
        if (singleDao.selectMax() != null) {
            String where = "{\"updatedAt\":{\"$gt\":\"" + singleDao.selectMax() + "\"}}";
//            String where="%7B\"updatedAt\":%7B\"$gt\":\""+singleDao.selectMax()+"\"%7D%7D";
            OkgoLoader.getInstance().sendByGet(BaseUrl.JUDGE + "?where=" + where, new GsonCallBack<BaseBean<JudgeBean>>(new TypeToken<BaseBean<JudgeBean>>() {
            }.getType()) {
                @Override
                public void onSuccess(BaseBean<JudgeBean> baseBean, Call call, Response response) {
                    List<JudgeBean> list = baseBean.getResults();
                    JudgeDao judgeDao = new JudgeDao(getApplicationContext());
                    judgeDao.add(list);
                }

                @Override
                public void onError(Call call, Response response, Exception e) {

                }
            });
        } else {
            OkgoLoader.getInstance().sendByGet(BaseUrl.JUDGE, new GsonCallBack<BaseBean<JudgeBean>>(new TypeToken<BaseBean<JudgeBean>>() {
            }.getType()) {
                @Override
                public void onSuccess(BaseBean<JudgeBean> baseBean, Call call, Response response) {
                    List<JudgeBean> list = baseBean.getResults();
                    JudgeDao judgeDao = new JudgeDao(getApplicationContext());
                    judgeDao.add(list);
                }

                @Override
                public void onError(Call call, Response response, Exception e) {

                }
            });
        }
    }



    @OnClick({R.id.rb_single, R.id.rb_single_exam, R.id.rb_many, R.id.rb_many_exam, R.id.rb_judge, R.id.rb_judge_exam})
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.rb_single:
                intent = new Intent(this, ExamActivity.class);
                intent.putExtra("type", "1");
                startActivity(intent);
                break;
            case R.id.rb_single_exam:
                intent = new Intent(this, ExamActivity.class);
                intent.putExtra("type", "1");
                startActivity(intent);
                break;
            case R.id.rb_many:
                intent = new Intent(this, ExamActivity.class);
                intent.putExtra("type", "1");
                startActivity(intent);
                break;
            case R.id.rb_many_exam:
                intent = new Intent(this, ExamActivity.class);
                intent.putExtra("type", "1");
                startActivity(intent);
                break;
            case R.id.rb_judge:
                intent = new Intent(this, ExamActivity.class);
                intent.putExtra("type", "1");
                startActivity(intent);
                break;
            case R.id.rb_judge_exam:
                intent = new Intent(this, ExamActivity.class);
                intent.putExtra("type", "1");
                startActivity(intent);
                break;
        }
    }


}
