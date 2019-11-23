package com.jj.wxapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Copyright (C), 2018-2019
 * Author: ziqimo
 * Date: 2019-11-17 08:11
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public class MyNetReceiver extends BroadcastReceiver {


    private NetCall netCall;

    public MyNetReceiver(NetCall netCall) {
        this.netCall = netCall;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (netCall != null) {
            netCall.isNetworkAvailable(!isNetworkAvailable(context));
        }
    }


    /**
     * 网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager mgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] info = mgr.getAllNetworkInfo();
        if (info != null) {
            for (int i = 0; i < info.length; i++) {
                if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }


}
