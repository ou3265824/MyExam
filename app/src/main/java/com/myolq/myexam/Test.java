package com.myolq.myexam;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */

public class Test {
}

//package com.example.myviewpager;
//
//        import java.util.ArrayList;
//        import java.util.List;
//
//        import android.app.Activity;
//        import android.os.Bundle;
//        import android.support.v4.view.PagerAdapter;
//        import android.support.v4.view.ViewPager;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//
//public class MainActivity extends Activity {
//    ViewPager pager;
//    List<View> views;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        pager = (ViewPager)findViewById(R.id.view_pager);
//        views = new ArrayList<View>();
//
//        LayoutInflater mLi = LayoutInflater.from(this);
//        View view1 = mLi.inflate(R.layout.view1, null);
//        View view2 = mLi.inflate(R.layout.view2, null);
//        View view3 = mLi.inflate(R.layout.view3, null);
//        views.add(view3);
//        views.add(view2);
//        views.add(view1);
//
//        MyPagerAdapter adapter = new MyPagerAdapter();
//        pager.setAdapter(adapter);
//    }
//
//
//    class MyPagerAdapter extends PagerAdapter {
//
//        @Override
//        public int getCount() {
//            // TODO Auto-generated method stub
//            return views.size();
//        }
//
//        @Override
//        public boolean isViewFromObject(View arg0, Object arg1) {
//            // TODO Auto-generated method stub
//            return arg0 == arg1;    //这行代码很重要，它用于判断你当前要显示的页面
//        }
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            container.addView(views.get(position));
//            return views.get(position);
//        }
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            container.removeView(views.get(position));
//        }
//
//    }
//}

