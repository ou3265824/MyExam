package com.myolq.frame.Utils;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by Administrator on 2017/3/17.
 */

public class TimeUtils {

    public static String rail="yyyy-MM-dd HH:mm:ss";


    public static String getCurrentTime(){
            long time=System.currentTimeMillis();//long now = android.os.SystemClock.uptimeMillis();
            SimpleDateFormat format=new SimpleDateFormat(rail);
            Date d1=new Date(time);
            String t1=format.format(d1);
            Log.e("msg", t1);
        return t1;
    }

    public static String getCurrentTime(String s){
        long time=System.currentTimeMillis();//long now = android.os.SystemClock.uptimeMillis();
        SimpleDateFormat format=new SimpleDateFormat(s);
        Date d1=new Date(time);
        String t1=format.format(d1);
        Log.e("msg", t1);
        return t1;
    }

    public static String getTime(long l){
        SimpleDateFormat format=new SimpleDateFormat(rail);
        Date d1=new Date(l);
        String t1=format.format(d1);
        Log.e("msg", t1);
        return t1;
    }
    public static String getTime(long l,String s){
        SimpleDateFormat format=new SimpleDateFormat(s);
        Date d1=new Date(l);
        String t1=format.format(d1);
        Log.e("msg", t1);
        return t1;
    }

    /**
     * 调此方法输入所要转换的时间输入例如（"2014-06-14-16-09-00"）返回时间戳
     *
     * @param time
     * @return
     */
    public static String dataOne(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat(rail,
                Locale.CHINA);
        Date date;
        String times = null;
        try {
            date = sdr.parse(time);
            long l = date.getTime();
            String stf = String.valueOf(l);
            times = stf.substring(0, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return times;
    }

    /*
    * 将时分秒转为秒数
    * */
    public static long formatTurnSecond(String time) {
        String s = time;
        int index1 = s.indexOf(":");
        int index2 = s.indexOf(":", index1 + 1);
        int hh = Integer.parseInt(s.substring(0, index1));
        int mi = Integer.parseInt(s.substring(index1 + 1, index2));
        int ss = Integer.parseInt(s.substring(index2 + 1));

//        Log.e(TAG, "formatTurnSecond: 时间== " + hh * 60 * 60 + mi * 60 + ss);
        return hh * 60 * 60 + mi * 60 + ss;
    }

    /*
        * 将秒数转为时分秒
        * */
    public static String secondFormatHms(int second) {
        int h = 0;
        int d = 0;
        int s = 0;
        String time="";
        int temp = second % 3600;
        if (second > 3600) {
            h = second / 3600;
            if (temp != 0) {
                if (temp > 60) {
                    d = temp / 60;
                    if (temp % 60 != 0) {
                        s = temp % 60;
                    }
                } else {
                    s = temp;
                }
            }
        } else {
            d = second / 60;
            if (second % 60 != 0) {
                s = second % 60;
            }
        }
        if (h<10){
            time+="0"+h;
        }
        if (d<10){
            time+=":0"+d;
        }
        if (s<10){
            time+=":0"+s;
        }
        return time;
    }


}
