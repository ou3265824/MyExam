package com.myolq.myexam.greendao.dao;

import com.myolq.frame.base.BaseApplication;
import com.myolq.myexam.greendao.GreenOpenHelper;
import com.myolq.myexam.greendao.bean.SingleBean;
import com.myolq.myexam.greendao.db.DaoSession;
import com.myolq.myexam.greendao.db.SingleBeanDao;

import static com.myolq.myexam.greendao.GreenOpenHelper.getDaoInstant;

/**
 * Created by Administrator on 2017/3/15.
 */

public class SingleDao {

    private static SingleDao singleDao;
    private static SingleBeanDao singleBeanDao;

    private SingleDao() {
        singleBeanDao = GreenOpenHelper.getDaoInstant().getSingleBeanDao();
    }

    public static SingleDao getInstance(){
        if (singleDao==null){
            synchronized (GreenOpenHelper.class){
                if (singleDao==null){
                    singleDao=new SingleDao();
                }
            }
        }
        return singleDao;
    }

    /**
     * 添加数据，如果有重复则覆盖
     *
     * @param
     */
    public void insertSingle(SingleBean singleBean) {
//        BaseApplication.getDaoInstant().getShopDao().insertOrReplace(shop);
        singleBeanDao.insert(singleBean);
    }


}
