package com.jingang.digitalwallet.base;

import java.lang.ref.WeakReference;

/**
* @Description:
* @Author: jingang.Li
* @CreateTime: 2021/7/11-10:17 AM
*/
public abstract class BasePresenter <V extends IView>  implements IPresenter<V>   {
    protected WeakReference<V> mView;

    @Override
    public void attachView(V view) {
        mView= new WeakReference<>(view);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void detachView() {
        if(mView!=null){
//            清楚弱引用--所指
            mView.clear();
//            回收弱引用对象
            mView=null;
        }
    }
}
