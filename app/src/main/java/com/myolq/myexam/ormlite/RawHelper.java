package com.myolq.myexam.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.myolq.myexam.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/9/19.
 */
public class RawHelper {

    private final String DB_DIR;
    /**存入本地的数据库名
     * 注意：每次app中放入新的数据库时都要升级一下DB_NAME和DB_OLDNAME,DB_OLDNAME_JOURNAL，目的是导入新的数据库，删除老的数据库
     * */
    private final String DB_NAME = "exam.db";
    private final String DB_OLDNAME = "todaycode_raw.db";
    //生成数据库时用事务进行插入产生的日志文件，也要随同删除
    private final String DB_OLDNAME_JOURNAL = "todaycode_raw.db-journal";
    private AndroidConnectionSource connectionSource;
    private static RawHelper dbHelper;

    public static String SQL_CURRENCY="delete from currency";
    public static String SQL_FUTURES="delete from futures";
    public static String SQL_PLATE="delete from plate";
    public static String SQL_STOCK="delete from stock";
    public static String SQL_SYSDICT="delete from sysdict";
    public static String SQL_UPPERTICK="delete from uppertick";
    public static String SQL_TRADEPLATE="delete from tradeplate";

    public static RawHelper getInstance(Context context) {
        if (dbHelper == null) {
            synchronized (RawHelper.class){
                if (dbHelper==null){
                    dbHelper = new RawHelper(context);
                }
            }

        }
        return dbHelper;
    }

    public RawHelper(Context context) {
        DB_DIR= context.getApplicationContext().getDatabasePath("code").getAbsolutePath();
        File dir = new File(DB_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //导入新的数据库
        File file = new File(dir, DB_NAME);
//        if (!file.exists()) {
//            try {
//
////                loadFile(context, file, R.raw.todaycode_raw20170301_3);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        //删除老的数据库
        File oldFile = new File(dir, DB_OLDNAME);
        if (oldFile.exists()){
            deleteFile(oldFile.toString());
        }
        //删除老的数据库随带的日志文件
        File oldFile_journal = new File(dir, DB_OLDNAME_JOURNAL);
        if (oldFile_journal.exists()){
            deleteFile(oldFile_journal.toString());
        }
        SQLiteDatabase db = SQLiteDatabase.openDatabase(file.getPath(), null,
                SQLiteDatabase.OPEN_READWRITE);
        connectionSource = new AndroidConnectionSource(db);
    }

    /**
     * 下在文件到指定目录
     *
     * @param context
     * @param file
     *            sd卡中的文件
     * @param id
     *            raw中的文件id
     * @throws IOException
     */
    public static void loadFile(Context context, File file, int id)
            throws IOException {
        InputStream is = context.getResources().openRawResource(id);
        FileOutputStream fos = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = is.read(buffer)) > 0) {
            fos.write(buffer, 0, count);
        }
        fos.close();
        is.close();
    }

    /**
     * 获取dao
     *
     * @param clazz
     * @return
     * @throws SQLException
     */
    public <D extends Dao<T, ?>, T> D getDao(Class<T> clazz) throws Exception {
        if (connectionSource != null) {
            return DaoManager.createDao(connectionSource, clazz);
        }
        return null;
    }

    public boolean deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }

    public void close(){
        if (dbHelper!=null){
            dbHelper=null;
        }
    }

}
