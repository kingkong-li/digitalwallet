package com.jingang.digitalwallet.base;

/**
 * @Description:
 * @Author: jingang.Li
 * @CreateTime: 2021/7/11-10:35 AM
 */
public interface IPresenter<V extends IView>  {
     void attachView(V v);
     void onCreate();
     void onStart();
     void onResume();
     void onPause();
     void onStop();
     void onDestroy();
     void detachView();
}
