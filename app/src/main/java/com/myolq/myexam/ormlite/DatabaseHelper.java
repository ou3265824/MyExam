package com.myolq.myexam.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.myolq.myexam.ormlite.bean.JudgeBean;
import com.myolq.myexam.ormlite.bean.ManyBean;
import com.myolq.myexam.ormlite.bean.SingleBean;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/19.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String SQLITE_NAME = "exam.db";
    private Map<String, Dao> daos = new HashMap<String, Dao>();
    private static DatabaseHelper instance;

//    public static String SQL_FASTORDER="delete from fastorder";
//    public static String SQL_MYCHOOSE="delete from mychoose";
//    public static String SQL_USER="delete from user";

    private DatabaseHelper(Context context)
    {
        super(context, SQLITE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            //存放自选数据的表
            TableUtils.createTableIfNotExists(connectionSource, SingleBean.class);
            TableUtils.createTableIfNotExists(connectionSource, ManyBean.class);
            TableUtils.createTableIfNotExists(connectionSource, JudgeBean.class);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**更新数据库版本时会运行的方法*/
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVersion, int newVersion) {

//        if (oldVersion==1){
//            try {
//                //删除
//                TableUtils.dropTable(connectionSource, FastOrderBean.class, true);
//                //存放一键下单设置过的合约的表
//                TableUtils.createTableIfNotExists(connectionSource, FastOrderBean.class);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

        /*try {
            *//*TableUtils.dropTable(connectionSource, FuturesBean.class, true);
            TableUtils.dropTable(connectionSource, StockBean.class, true);
            TableUtils.dropTable(connectionSource, PlateBean.class, true);
            TableUtils.dropTable(connectionSource, CurrencyBean.class, true);
            TableUtils.dropTable(connectionSource, UpperTickBean.class, true);
            TableUtils.dropTable(connectionSource, SysDictBean.class, true);
            TableUtils.dropTable(connectionSource,MyChooseBean.class,true);
            TableUtils.dropTable(connectionSource,FastOrderBean.class,true);
            onCreate(sqLiteDatabase, connectionSource);*//*
            //数据库版本升级对数据库进行操作，主要是增删表格
            *//**
             * 示例 演示用。。。
             * 2.0.0版本：5       增加自选表
             * 2.1.0版本：6       增加快速下单设置表
             *//*
            switch (oldVersion) {
                case 4:
                    TableUtils.createTableIfNotExists(connectionSource,MyChooseBean.class);
                case 5:
                    TableUtils.createTableIfNotExists(connectionSource,FastOrderBean.class);
                default:
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    /**
     * 单例获取该Helper
     *
     * @param context
     * @return
     */
    public static synchronized DatabaseHelper getHelper(Context context)
    {
        context = context.getApplicationContext();
        if (instance == null)
        {
            synchronized (DatabaseHelper.class)
            {
                if (instance == null)
                    instance = new DatabaseHelper(context);
            }
        }

        return instance;
    }

    public synchronized Dao getDao(Class clazz) throws SQLException
    {
        Dao dao = null;
        String className = clazz.getSimpleName();

        if (daos.containsKey(className))
        {
            dao = daos.get(className);
        }
        if (dao == null)
        {
            dao = super.getDao(clazz);
            daos.put(className, dao);
        }
        return dao;
    }

    /**
     * 释放资源
     */
    @Override
    public void close()
    {
        super.close();

        for (String key : daos.keySet())
        {
            Dao dao = daos.get(key);
            dao = null;
        }
    }

}
