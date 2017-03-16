package com.myolq.myexam.ormlite.dao;

import android.content.Context;
import android.text.format.DateUtils;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.myolq.frame.Utils.L;
import com.myolq.myexam.ormlite.DatabaseHelper;
import com.myolq.myexam.ormlite.bean.SingleBean;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 */

public class SingleDao {

    private Context context;
    private Dao<SingleBean, Integer> dao;
    private DatabaseHelper helper;
    QueryBuilder builder;

    public SingleDao(Context context)
    {
        this.context = context;
        try
        {
            helper = DatabaseHelper.getHelper(context);
            dao = helper.getDao(SingleBean.class);

            builder = dao.queryBuilder();
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
            dao.createOrUpdate(user);
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


    /**
     * 插入
     * @param
     */
    public void add(final List<SingleBean> list)
    {
        if(list==null || list.size()==0){
            return;
        }
        L.log("开始："+System.currentTimeMillis());

        //使用数据库事务，加速大批量的数据插入
        try {
            dao.callBatchTasks(new Callable<Object>() {

                @Override
                public Object call() throws Exception {
                    for (int i = 0; i < list.size(); i++) {
                        SingleBean bean = list.get(i);
                        try {
                            dao.createOrUpdate(bean);  //插入或者是更新（由主键确定是否更新）
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    L.log("结束："+System.currentTimeMillis());
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //
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

    public List<SingleBean> selectSingleList(){

        try {
            List<SingleBean> bean =  builder.orderBy("updatedAt",false).query();

            if (bean!=null){

                return bean;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

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
