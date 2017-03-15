package com.myolq.myexam.ormlite;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.myolq.myexam.ormlite.bean.SingleBean;

import java.sql.SQLException;

/**
 *
 */

public class SingleDao {

    private Context context;
    private Dao<SingleBean, Integer> userIntegerDao;
    private DatabaseHelper helper;
    QueryBuilder builder;

    public SingleDao(Context context)
    {
        this.context = context;
        try
        {
            helper = DatabaseHelper.getHelper(context);
            userIntegerDao = helper.getDao(SingleBean.class);

            builder = userIntegerDao.queryBuilder();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void releaseHelper(){
        if (helper != null) {
            OpenHelperManager.releaseHelper();
            helper = null;
        }
    }

    /**
     * 插入
     * @param user
     */
    public void add(SingleBean user) {
        try
        {
            userIntegerDao.createOrUpdate(user);
//            List<UserBean> chooseList = builder.query();
            //LogUtils.i("添加时自选表查询全部", chooseList.size());
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

//    public void delete(){
//        try {
//            userIntegerDao.queryRaw(DatabaseHelper.SQL_USER);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    //最近登录的用户数据
    public SingleBean selectMaxUser(String type){

        try {
            SingleBean userBean = (SingleBean) builder.orderBy("updateDate",false).where().eq("type",type).queryForFirst();

            if (userBean!=null){

                return userBean;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //查询数据库的是否有这条数据
//    public UserBean selectUser(String accountName,String password,String type, String sysdictValue){
//
//        try {
//            UserBean userBean = (UserBean) builder.orderBy("updateDate",false).where().eq("accountName",accountName).and().eq("password",password).and().eq("type",type).and().eq("sysdictValue",sysdictValue).queryForFirst();
//
//            if (userBean!=null){
//
//                return userBean;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    //修改数据库的最新一条数据
//    public void updateUser(UserBean userBean){
//
//        try {
//            userIntegerDao.createOrUpdate(userBean);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


//    public UserBean selectNewUser(String type,String sysdictValue){
//
//        try {
//            UserBean userBean = (UserBean) builder.orderBy("updateDate",false).where().eq("type",type).and().eq("sysdictValue",sysdictValue).queryForFirst();
//            if (userBean!=null){
//                return userBean;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }




}
