package com.jingang.digitalwallet.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * @Description:
 * @Author: jingang.Li
 * @CreateTime: 2021/7/11-9:54 PM
 */
public abstract class BaseFragment<P extends IPresenter> extends Fragment implements IView {
    protected P mPresenter;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
            mPresenter.onCreate();
        }
        if (savedInstanceState != null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.hide(this);
            transaction.commit();
        }

    }

    /**
     * 创建Presenter（如果没有Presenter层则返回null即可）
     *
     * @return Presenter层对象
     */
    protected abstract P createPresenter();

    @Override
    public void onStart() {
        super.onStart();
        if(mPresenter!=null){
            mPresenter.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(mPresenter!=null){
            mPresenter.onResume();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mPresenter!=null){
            mPresenter.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.onDestroy();
        }
    }
}
