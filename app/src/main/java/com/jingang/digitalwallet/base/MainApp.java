package com.jingang.digitalwallet.base;

import android.app.Application;

/**
 * @Description: Application单例 方便获取context
 * @Author: jingang.Li
 * @CreateTime:2021/7/10-4:40 PM
 */
public class MainApp extends Application {
    private static MainApp sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance=this;
    }

    public static MainApp getApplication(){
        return sInstance;
    }

}
