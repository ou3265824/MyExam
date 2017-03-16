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
import com.myolq.myexam.ormlite.dao.SingleDao;
import com.myolq.myexam.ormlite.bean.SingleBean;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class HomeActivity extends InitActivity
         {

    @BindView(R.id.rb_title)
    RadioButton rbTitle;
    @BindView(R.id.rb_exam)
    RadioButton rbExam;

    @Override
    public int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void onCreate() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        OkgoLoader.getInstance().sendByGet(BaseUrl.SINGLE, new GsonCallBack<BaseBean<SingleBean>>(new TypeToken<BaseBean<SingleBean>>(){}.getType()) {
            @Override
            public void onSuccess(BaseBean<SingleBean> baseBean, Call call, Response response) {
//                L.log(baseBean.getResults().get(0).getTitleName());
//                L.log(baseBean.getResults().get(0).getTitleName());
//                L.log(baseBean.getResults().get(0).getTitleName());
                List<SingleBean> list=baseBean.getResults();
                SingleDao singledao=new SingleDao(getApplicationContext());
                singledao.add(list);
            }

            @Override
            public void onError(Call call, Response response, Exception e) {

            }
        });
    }

    @OnClick({R.id.rb_title, R.id.rb_exam})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_title:
                startActivity(new Intent(this,ExamActivity.class));
                break;
            case R.id.rb_exam:
                startActivity(new Intent(this,ExamActivity.class));
                break;
        }
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        OkgoLoader.getInstance().sendByGet(BaseUrl.SUBJECT, new StringCallBack() {
//            @Override
//            public void onSuccess(String s, Call call, Response response) {
//                L.log(s);
//            }
//
//            @Override
//            public void onError(Call call, Response response, Exception e) {
//
//            }
//        });
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
//    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }



}
