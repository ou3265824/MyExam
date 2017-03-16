//package com.myolq.myexam.greendao;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//
//import com.myolq.myexam.greendao.db.DaoMaster;
//import com.myolq.myexam.greendao.db.DaoSession;
//
///**
// * Created by Administrator on 2017/3/15.
// */
//
//public class GreenOpenHelper {
//
//    private static DaoSession daoSession;
//    private static GreenOpenHelper greenOpenHelper;
//    private String SqliteName="exam.db";
//
//    private GreenOpenHelper() {
//
//    }
//
//    public static GreenOpenHelper getInstance(){
//        if (greenOpenHelper==null){
//            synchronized (GreenOpenHelper.class){
//                if (greenOpenHelper==null){
//                    greenOpenHelper=new GreenOpenHelper();
//                }
//            }
//        }
//        return greenOpenHelper;
//    }
//
//    /**
//     * 配置数据库
//     */
//    public void setupDatabase(Context context) {
//        //创建数据库shop.db"
//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, SqliteName, null);
//        //获取可写数据库
//        SQLiteDatabase db = helper.getWritableDatabase();
//        //获取数据库对象
//        DaoMaster daoMaster = new DaoMaster(db);
//        //获取Dao对象管理者
//        daoSession = daoMaster.newSession();
//    }
//
//    public static DaoSession getDaoInstant() {
//        return daoSession;
//    }
//
//}
