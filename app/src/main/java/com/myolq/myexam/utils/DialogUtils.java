package com.myolq.myexam.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by Administrator on 2017/3/17.
 */

public class DialogUtils {

    public static void createAlertDialog(Context context, String title, String msg, DialogInterface.OnClickListener onClickListener) {
        new AlertDialog.Builder(context).setTitle(title).setMessage(msg).setPositiveButton("确认", onClickListener).setCancelable(false).create().show();
    }
}
